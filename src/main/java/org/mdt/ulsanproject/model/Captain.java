package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String licenseNumber;

    @Column(length = 255)
    private String nationality;

    @Column(length = 255)
    private String picture;

    private Integer yearsOfExperience; // Changed to Integer for consistency

    @Column(length = 255)
    private String certificates;

    @Column(length = 255)
    private String specializations;

    private LocalDate medicalClearanceDate;

    @Column
    private Integer assignedVesselId;

    @Column(length = 255)
    private String languagesKnown;

    @Column(length = 255)
    private String contactInfo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @Column(nullable = false)
    private boolean isDelete;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
