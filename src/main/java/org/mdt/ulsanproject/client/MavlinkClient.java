package org.mdt.ulsanproject.client;

import io.dronefleet.mavlink.MavlinkConnection;
import io.dronefleet.mavlink.MavlinkMessage;
import io.dronefleet.mavlink.common.*;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MavlinkClient implements Runnable {
    private final TelemetryService telemetryService;

    private final String missionPlannerHost = "localhost";
    private final int missionPlannerPort = 14550; // Self
//     private final int udpPort = 14556; // UDP Port for MAVLink messages
    // private final int udpPort = 14557; // Alternate UDP Port for MAVLink messages

    private final Map<String, Object> telemetryData = new HashMap<String, Object>() {{
        put("lat", 0.0);
        put("lon", 0.0);
        put("alt", 0.0);
        put("dist_traveled", 0);
        put("wp_dist", 0.0);
        put("dist_to_home", 0.0);
        put("vertical_speed", 0.0);
        put("wind_vel", 0.0);
        put("airspeed", 0.0);
        put("groundspeed", 0.0);
        put("roll", 0.0);
        put("pitch", 0.0);
        put("yaw", 0.0);
        put("toh", 0.0);
        put("tot", 0.0);
        put("time_in_air", 0.0);
        put("time_in_air_min_sec", 0.0);
        put("gps_hdop", 0.0);
        put("battery_voltage", 0.0);
        put("battery_current", 0.0);
        put("ch3percent", 0.0);
        put("ch3out", 0.0);
        put("ch9out", 0.0);
        put("ch10out", 0.0);
        put("ch11out", 0.0);
        put("ch12out", 0.0);
        put("waypoints", new ArrayList<String>());
    }};

    private long startTime = System.currentTimeMillis();  // Track the start time

    public MavlinkClient(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    public void startListening() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        // Start TCP listener in a separate thread
        new Thread(this::startTcpListener).start();

        // Uncomment to start UDP listener
      //  startUdpListener();
    }

//    private void startUdpListener() {
//        try (DatagramSocket datagramSocket = new DatagramSocket(udpPort)) {
//            System.out.println("Listening for MAVLink messages on UDP port " + udpPort);
//
//            byte[] buffer = new byte[2048];
//            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//
//            while (true) {
//                datagramSocket.receive(packet);
//                System.out.println("Received UDP packet from " + packet.getAddress() + ":" + packet.getPort());
//
//                try (InputStream inputStream = new ByteArrayInputStream(packet.getData(), packet.getOffset(), packet.getLength())) {
//                    MavlinkConnection connection = MavlinkConnection.create(inputStream, null);
//                    MavlinkMessage<?> mavlinkMessage = connection.next();
//                    if (mavlinkMessage != null) {
//                        processTelemetryMessage(mavlinkMessage);
//                    }
//                } catch (Exception e) {
//                    if (!"End of stream".equals(e.getMessage())) {
//                        System.err.println("Error processing UDP MAVLink message: " + e.getMessage());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error in UDP Listener: " + e.getMessage());
//        }
//    }

    private void startTcpListener() {
        try (Socket socket = new Socket(missionPlannerHost, missionPlannerPort);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            MavlinkConnection connection = MavlinkConnection.create(inputStream, outputStream);
            System.out.println("Connected to TCP server at " + missionPlannerHost + ":" + missionPlannerPort);

            while (true) {
                MavlinkMessage<?> mavlinkMessage = connection.next();
                if (mavlinkMessage != null) {
                    processTelemetryMessage(mavlinkMessage);
                }
            }
        } catch (Exception e) {
            System.err.println("Error in TCP Listener: " + e.getMessage());
        }
    }

    private void processTelemetryMessage(MavlinkMessage<?> mavlinkMessage) {
        Object payload = mavlinkMessage.getPayload();

        // Calculate time in air
        long currentTime = System.currentTimeMillis();
        double timeInAir = (currentTime - startTime) / 1000.0; // Time in seconds
        telemetryData.put("time_in_air", timeInAir);

        // Calculate time in air in minutes and seconds
        double timeInAirMinSec = Math.round(timeInAir / 60.0 + (timeInAir % 60) / 100.0);
        telemetryData.put("time_in_air_min_sec", timeInAirMinSec);

        // Process other telemetry data based on message payload type
        if (payload instanceof GpsRawInt gpsData) {
            telemetryData.put("lat", gpsData.lat() / 1e7);
            telemetryData.put("lon", gpsData.lon() / 1e7);
            telemetryData.put("alt", gpsData.alt() / 1000.0);
            telemetryData.put("gps_hdop", gpsData.eph() / 100.0);
        } else if (payload instanceof VfrHud vfrHud) {
            telemetryData.put("airspeed", vfrHud.airspeed());
            telemetryData.put("groundspeed", vfrHud.groundspeed());
            telemetryData.put("heading", vfrHud.heading());
            telemetryData.put("vertical_speed", vfrHud.climb());
        } else if (payload instanceof Attitude attitude) {
            telemetryData.put("roll", Math.toDegrees(attitude.roll()));
            telemetryData.put("pitch", Math.toDegrees(attitude.pitch()));
            telemetryData.put("yaw", Math.toDegrees(attitude.yaw()));
        } else if (payload instanceof GlobalPositionInt globalPosition) {
            telemetryData.put("alt", globalPosition.relativeAlt() / 1000.0); // Relative altitude
            telemetryData.put("dist_to_home", globalPosition.hdg()); // Heading
        } else if (payload instanceof NavControllerOutput navControllerOutput) {
            telemetryData.put("wp_dist", navControllerOutput.wpDist()); // Waypoint distance
        } else if (payload instanceof MissionCurrent missionCurrent) {
            telemetryData.put("current_wp", missionCurrent.seq()); // Current waypoint index
        } else if (payload instanceof SysStatus sysStatus) {
            telemetryData.put("battery_voltage", sysStatus.voltageBattery() / 1000.0); // Battery voltage (V)
            telemetryData.put("battery_current", sysStatus.currentBattery() / 100.0); // Battery current (A)
            telemetryData.put("time_in_air", sysStatus.onboardControlSensorsEnabled()); // Approximation
        } else if (payload instanceof RcChannels rcChannels) {
            telemetryData.put("ch9out", rcChannels.chan9Raw()); // Channel 9 output
        } else if (payload instanceof MissionItemInt missionItem) {
            List<String> waypoints = (List<String>) telemetryData.get("waypoints");
            waypoints.add("Lat: " + (missionItem.x() / 1e7) + ", Lon: " + (missionItem.y() / 1e7));
            telemetryData.put("waypoints", waypoints);
        }

        // Output telemetry data
        System.out.println("Output of telemetry data: " + telemetryData);
        telemetryService.outputTelemetryData(telemetryData.toString());
    }
}
