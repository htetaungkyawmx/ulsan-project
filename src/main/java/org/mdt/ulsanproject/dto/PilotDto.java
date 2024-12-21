package org.mdt.ulsanproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PilotDto {
    private int id;
    private String serialNumber;
    private String name;
    private String personalNo;
    private String passportNo;
    private String image;
    private float flightTime;
    private int accidentCounts;
    private String address;
    private boolean medicalCertificate;
    private String experienceLevel;
    private float averageMissionDuration;
    private String registrationDroneId;
    private String contact;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isDelete;
}
