package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.CompanyDto;
import org.mdt.ulsanproject.model.Company;

import java.util.List;

public interface CompanyService {
    Company save(CompanyDto companyDto);
    Company update(int id, CompanyDto companyDto);
    List<Company> findAll();
    void delete(int id);
}