package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "flight_logs")
public class FlightLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pilot_serial_number", length = 255)
    private String pilotSerialNumber;

    @Column(name = "drone_serial_number", length = 255)
    private String droneSerialNumber;

    @Column(name = "flight_idx", length = 255)
    private String flightIndex;

    @Column(name = "datetime")
    private LocalDateTime flightDateTime;

    @Column(name = "wind_churning_wind", length = 255)
    private String windChurningWind;

    @Column(name = "battery_serial_number", length = 255)
    private String batterySerialNumber;

    @Column(name = "takeoff_time")
    private LocalDateTime takeoffTime;

    @Column(name = "takeoff_situation_speed", length = 255)
    private String takeoffSituationSpeed;

    @Column(name = "takeoff_position", length = 255)
    private String takeoffPosition;

    @Column(name = "takeoff_landmark", length = 255)
    private String takeoffLandmark;

    @Column(name = "landing_time")
    private LocalDateTime landingTime;

    @Column(name = "landing_situation_vessel_speed", length = 255)
    private String landingSituationVesselSpeed;

    @Column(name = "land_map", length = 255)
    private String landMap;

    @Column(name = "landing_map", length = 255)
    private String landingMap;

    @Column(name = "flight_time_minutes")
    private Integer flightTimeMinutes;

    @Column(name = "flight_radius_km")
    private Float flightRadiusKm;

    @Column(name = "flight_distance_km")
    private Float flightDistanceKm;

    @Column(name = "cruise_flight_altitude_m")
    private Float cruiseFlightAltitudeMeters;

    @Column(name = "cruise_flight_speed_ms")
    private Float cruiseFlightSpeedMetersPerSecond;

    @Column(name = "whitewave1_discovery_time")
    private LocalDateTime whiteWave1DiscoveryTime;

    @Column(name = "whitewave1_latitude", length = 255)
    private String whiteWave1Latitude;

    @Column(name = "whitewave1_hardness", length = 255)
    private String whiteWave1Hardness;

    @Column(name = "whitewave1_shooting_altitude", length = 255)
    private String whiteWave1ShootingAltitude;

    @Column(name = "whitewave1_shooting_speed", length = 255)
    private String whiteWave1ShootingSpeed;

    @Column(name = "whitewave1_shooting_radius", length = 255)
    private String whiteWave1ShootingRadius;

    @Column(name = "whitewave1_detected_fish", length = 255)
    private String whiteWave1DetectedFish;

    @Column(name = "whitewave1_detected_tones", length = 255)
    private String whiteWave1DetectedTones;

    @Column(name = "whitewave1_vessel_mission_status", length = 255)
    private String whiteWave1VesselMissionStatus;

    @Column(name = "whitewave2_discovery_time")
    private LocalDateTime whiteWave2DiscoveryTime;

    @Column(name = "whitewave2_latitude", length = 255)
    private String whiteWave2Latitude;

    @Column(name = "whitewave2_hardness", length = 255)
    private String whiteWave2Hardness;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
