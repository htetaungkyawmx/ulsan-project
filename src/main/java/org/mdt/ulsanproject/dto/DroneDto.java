package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneDto {
    private String model;
    private String manufacturer;
    private String weight;
    private String maxAltitude;
    private String batteryCapacity;
    private String operatingRange;

}
