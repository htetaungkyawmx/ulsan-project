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
public class Vessel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialnumber;  // Unique serial number for the vessel
    private String name;  // Vessel name
    private String type;  // Vessel type (e.g., cargo, tanker)
    private String manufacturer;  // Manufacturer name
    private String picture;  // URL or file path to vessel image
    private float weight;  // Weight of the vessel in tons
    private float capacity;  // Cargo/passenger capacity in tons
    private String IMO;  // International Maritime Organization number
    private String MMSI;  // Maritime Mobile Service Identity number
    private String callsign;  // Callsign of the vessel
    private String nation;  // Nation of registration
    private float length;  // Length of the vessel in meters

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate = LocalDateTime.now();  // Record creation timestamp

    @Column(name = "updated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedDate = LocalDateTime.now();  // Last update timestamp

    private boolean isDelete = false;  // Logical delete flag

    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Vessel{id=" + id + ", name='" + name + "', type='" + type + "', serialnumber='" + serialnumber + "'}";
    }
}
