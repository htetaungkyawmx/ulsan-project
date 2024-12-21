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

    @Column(nullable = false)
    private String droneId;

    @Column(nullable = false)
    private String serialNo;

    private String fcVersion;
    private String controller;
    private String motor;
    private String camera;
    private String battery;
    private String charger;
    private String communicationType;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;
    private String part6;
    private String part7;
    private String part8;
    private String description;

    @Column(nullable = false)
    private LocalDate maintenanceDate;

    private Double cost;

    @Column(nullable = false)
    private Boolean isResolved;

    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

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
