package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drones")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "drone_code", unique = true, nullable = false)
    @NotNull
    private String droneCode;

    @Column(name = "drone_model", nullable = false)
    private String droneModel;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "drone_type")
    private String droneType;

    @Column(name = "category")
    private String category;

    @Column(name = "weight", nullable = false)
    private float weight;

    @Column(name = "max_altitude", nullable = false)
    private float maxAltitude;

    @Column(name = "battery_capacity", nullable = false)
    private float batteryCapacity;

    @Column(name = "operating_range", nullable = false)
    private float operatingRange;

    @Column(name = "serial_no", unique = true, nullable = false)
    private String serialNo;

    @Column(name = "controller", nullable = false)
    private String controller;

    @Column(name = "motor", nullable = false)
    private String motor;

    @Column(name = "camera", nullable = false)
    private String camera;

    @Column(name = "battery", nullable = false)
    private String battery;

    @Column(name = "charger", nullable = false)
    private String charger;

    @Column(name = "communication_type", nullable = false)
    private String communicationType;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "is_delete", nullable = false)
    private boolean isDelete = false;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
