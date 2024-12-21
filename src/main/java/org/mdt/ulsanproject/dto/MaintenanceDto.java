package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDto {
    private String droneId;
    private String serialNo;
    private String fcVersion;
    private String controller;
    private String motor;
    private String camera;
    private String battery;
    private String charger;
    private String communicationType;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;
    private String part6;
    private String part7;
    private String part8;
    private String description;
    private LocalDate maintenanceDate;
    private Double cost;
    private Boolean isResolved;
}
