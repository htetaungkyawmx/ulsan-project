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

    private String serialnumber;
    private String name;
    private String type;
    private String manufacturer;
    private String picture;
    private float weight;
    private float capacity;
    private String IMO;
    private String MMSI;
    private String callsign;
    private String nation;
    private float length;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedDate = LocalDateTime.now();

    private boolean isDelete = false;

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
