package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "drone")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String manufacturer;
    private String weight;
    private String max_altitude;
    private String battery_capacity;
    @Column(name = "operating_range")
    private String Operating_Range;

}
