package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.CompanyDto;
import org.mdt.ulsanproject.model.Company;
import org.mdt.ulsanproject.repository.CompanyRepository;
import org.mdt.ulsanproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(CompanyDto companyDto) {
        Company company = Company.builder()
                .name(companyDto.getName())
                .address(companyDto.getAddress())
                .email(companyDto.getEmail())
                .build();
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> update(int id, CompanyDto companyDto) {
        return companyRepository.findById(id).map(existingCompany -> {
            existingCompany.setName(companyDto.getName());
            existingCompany.setAddress(companyDto.getAddress());
            existingCompany.setEmail(companyDto.getEmail());
            return companyRepository.save(existingCompany);
        });
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(int id) {
        return companyRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        companyRepository.deleteById(id);
    }

}
