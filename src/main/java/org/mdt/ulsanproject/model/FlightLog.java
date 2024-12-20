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
    private Long id;

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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
}
