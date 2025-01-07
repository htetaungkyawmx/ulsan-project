package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "personal_no", nullable = false, unique = true)
    private String personalNo;

    @Column(name = "passport_no", nullable = false, unique = true)
    private String passportNo;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "flight_time", nullable = false)
    private float flightTime = 0.0f;

    @Column(name = "accident_counts", nullable = false)
    private int accidentCounts = 0;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "medical_certificate", nullable = false)
    private boolean medicalCertificate = false;

    @Column(name = "experience_level", nullable = false)
    private String experienceLevel = "Beginner";

    @Column(name = "average_mission_duration", nullable = false)
    private float averageMissionDuration = 0.0f;

    @Column(name = "registration_drone_id")
    private String registrationDroneId;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_delete", nullable = false)
    private boolean isDelete = false;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
