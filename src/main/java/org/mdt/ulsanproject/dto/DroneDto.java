package org.mdt.ulsanproject.dto;

import lombok.Data;

@Data
public class DroneDto {
    private String droneModel;
    private String manufacturer;
    private String droneType;
    private String category;
    private float weight;
    private float maxAltitude;
    private float batteryCapacity;
    private float operatingRange;
    private String droneCode; // This can be generated in the service layer
    private String image; // Image URL or path
    private String description; // Optional description for the drone
}
