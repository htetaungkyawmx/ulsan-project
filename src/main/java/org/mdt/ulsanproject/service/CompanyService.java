package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.CompanyDto;
import org.mdt.ulsanproject.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company save(CompanyDto companyDto);

    Optional<Company> update(int id, CompanyDto companyDto);

    List<Company> findAll();

    Optional<Company> findById(int id);

    void delete(int id);
}
