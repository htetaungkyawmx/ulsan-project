package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "drone_id", nullable = false)
    private String droneId;

    @Column(name = "serial_no", length = 255, nullable = false)
    private String serialNo;

    @Column(name = "fc_version", length = 255)
    private String fcVersion;

    @Column(name = "controller", length = 255)
    private String controller;

    @Column(name = "motor", length = 255)
    private String motor;

    @Column(name = "camera", length = 255)
    private String camera;

    @Column(name = "battery", length = 255)
    private String battery;

    @Column(name = "charger", length = 255)
    private String charger;

    @Column(name = "communication_type", length = 255)
    private String communicationType;

    @Column(name = "part_1", length = 255)
    private String part1;

    @Column(name = "part_2", length = 255)
    private String part2;

    @Column(name = "part_3", length = 255)
    private String part3;

    @Column(name = "part_4", length = 255)
    private String part4;

    @Column(name = "part_5", length = 255)
    private String part5;

    @Column(name = "part_6", length = 255)
    private String part6;

    @Column(name = "part_7", length = 255)
    private String part7;

    @Column(name = "part_8", length = 255)
    private String part8;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "maintenance_date")
    private LocalDate maintenanceDate;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "is_resolved", nullable = false)
    private Boolean isResolved;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }
}
