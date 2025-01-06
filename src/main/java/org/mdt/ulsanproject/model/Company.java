package org.mdt.ulsanproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String registrationNo;

    @Column(nullable = false, unique = true, length = 100)
    private String taxId;

    @Column(length = 255)
    private String logoUrl;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(length = 500)
    private String address;

    @Column(length = 100)
    private String industryType;

    @Column(nullable = true)
    private Integer noOfEmployees;

    @Column(nullable = true)
    private Double capital;

    @Column(nullable = true)
    private Double annualRevenue;

    @Column(length = 100)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String tags;

    @Column(length = 100)
    private String country;

    private LocalDateTime foundingDate;

    @Column(length = 255)
    private String website;

    @Column(length = 255)
    private String contactPerson;

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
