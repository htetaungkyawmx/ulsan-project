package org.mdt.ulsanproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CaptainBaseDto {
    private String name;
    private String licenseNumber;
    private String nationality;
    private String picture;
    private Integer yearsOfExperience; // Changed to Integer for consistency
    private String certificates;
    private String specializations;
    private LocalDate medicalClearanceDate;
    private Integer assignedVesselId;
    private String languagesKnown;
    private String contactInfo;
}
