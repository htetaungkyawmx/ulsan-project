package org.mdt.busanproject.service.impl;

import org.mdt.busanproject.dto.CompanyDto;
import org.mdt.busanproject.model.Company;
import org.mdt.busanproject.repository.CompanyRepository;
import org.mdt.busanproject.service.CompanyService;
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
                .email(companyDto.getEmail())
                .password(companyDto.getPassword())
                .build();
        return companyRepository.save(company);
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
    public Company findByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    @Override
    public boolean validateUser(String email, String password) {
        Company company = companyRepository.findByEmail(email);
        return company != null && company.getPassword().equals(password);
    }
}
