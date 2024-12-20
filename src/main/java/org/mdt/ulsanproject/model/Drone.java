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
@Table(name = "drones")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "drone_code", unique = true, nullable = false)
    private String droneCode;

    @Column(name = "drone_model")
    private String droneModel;

    private String manufacturer;

    @Column(name = "drone_type")
    private String droneType;

    private String category;

    private float weight;

    @Column(name = "max_altitude")
    private float maxAltitude;

    @Column(name = "battery_capacity")
    private float batteryCapacity;

    @Column(name = "range_km")
    private float range;

    @Column(name = "serial_no", unique = true)
    private String serialNo;

    private String controller;

    private String motor;

    private String camera;

    private String battery;

    private String charger;

    @Column(name = "communication_type")
    private String communicationType;

    @Column(nullable = false)
    private String image;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_delete", nullable = false)
    private boolean isDelete;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
