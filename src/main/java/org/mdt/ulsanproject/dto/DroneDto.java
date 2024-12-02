package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneDto {

    private int id;
    private String model;
    private String manufacturer;
    private String weight;
    private String max_altitude;
    private String battery_capacity;
    private String range;

}
