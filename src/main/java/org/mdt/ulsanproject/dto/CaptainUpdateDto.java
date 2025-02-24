package org.mdt.ulsanproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CaptainUpdateDto {
    private String name;
    private String licenseNumber;
    private String nationality;
    private String picture;
    private Integer yearsOfExperience;
    private String certificates;
    private String specializations;
    private LocalDate medicalClearanceDate;
    private Integer assignedVesselId;
    private String languagesKnown;
    private String contactInfo;
}
