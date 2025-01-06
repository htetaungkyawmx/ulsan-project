package org.mdt.ulsanproject.dto;

import lombok.Data;

@Data
public class DroneDto {
    private String droneCode; // Code generated in service
    private String droneModel;
    private String manufacturer;
    private String droneType;
    private String category;
    private float weight;
    private float maxAltitude;
    private float batteryCapacity;
    private float operatingRange;
    private String serialNo; // Added field
    private String controller; // Added field
    private String motor; // Added field
    private String camera; // Added field
    private String battery; // Added field
    private String charger; // Added field
    private String communicationType; // Added field
    private String image; // Image URL or path
    private String description; // Drone description
    private boolean isDelete; // For soft delete
}
