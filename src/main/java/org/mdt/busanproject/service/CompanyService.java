package org.mdt.busanproject.service;

import org.mdt.busanproject.dto.CompanyDto;
import org.mdt.busanproject.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company save(CompanyDto companyDto); // Save company details
    List<Company> findAll(); // Get all companies
    Optional<Company> findById(int id); // Find a company by ID
    Company findByEmail(String email); // Find a company by email
    boolean validateUser(String email, String password); // Validate login credentials
}
