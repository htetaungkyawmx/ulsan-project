package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightLogDto {
    private String pilotSerialNumber;
    private String droneSerialNumber;
    private String flightIdx;

    private String windChurningWind;
    private String batterySerialNumber;

    private LocalDateTime takeoffTime;
    private String takeoffSituationSpeed;
    private String takeoffPosition;
    private String takeoffLandmark;

    private LocalDateTime landingTime;
    private String landingSituationVesselSpeed;
    private String landMap;
    private String landingMap;

    private Integer flightTimeMinutes;
    private Double flightRadiusKm;
    private Double flightDistanceKm;
    private Double cruiseFlightAltitudeM;
    private Double cruiseFlightSpeedMs;

    private LocalDateTime whitewave1DiscoveryTime;
    private String whitewave1Latitude;
    private String whitewave1Hardness;
    private String whitewave1ShootingAltitude;
    private String whitewave1ShootingSpeed;
    private String whitewave1ShootingRadius;
    private String whitewave1DetectedFish;
    private String whitewave1DetectedTones;
    private String whitewave1VesselMissionStatus;

    private LocalDateTime whitewave2DiscoveryTime;
    private String whitewave2Latitude;
    private String whitewave2Hardness;
}
