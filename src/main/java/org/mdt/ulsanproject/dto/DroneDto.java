package org.mdt.ulsanproject.dto;

import lombok.Data;

@Data
public class DroneDto {
    private String droneCode;
    private String droneModel;
    private String manufacturer;
    private String droneType;
    private String category;
    private float weight;
    private float maxAltitude;
    private float batteryCapacity;
    private float operatingRange;
    private String serialNo;
    private String controller;
    private String motor;
    private String camera;
    private String battery;
    private String charger;
    private String communicationType;
    private String image;
    private String description;
    private boolean isDelete;
}
