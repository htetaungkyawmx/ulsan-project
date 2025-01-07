package org.mdt.ulsanproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private int id;
    private String name;
    private String registrationNo;
    private String taxId;
    private String logoUrl;
    private String email;
    private String address;
    private String industryType;
    private Integer noOfEmployees;
    private Double capital;
    private Double annualRevenue;
    private String status;
    private String tags;
    private String country;
    private String website;
    private String contactPerson;
}
