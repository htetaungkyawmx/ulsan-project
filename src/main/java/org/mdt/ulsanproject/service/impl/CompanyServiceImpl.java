package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.CompanyDto;
import org.mdt.ulsanproject.model.Company;
import org.mdt.ulsanproject.repository.CompanyRepository;
import org.mdt.ulsanproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
                .registrationNo(companyDto.getRegistrationNo())
                .taxId(companyDto.getTaxId())
                .logoUrl(companyDto.getLogoUrl())
                .email(companyDto.getEmail())
                .address(companyDto.getAddress())
                .industryType(companyDto.getIndustryType())
                .noOfEmployees(companyDto.getNoOfEmployees())
                .capital(companyDto.getCapital())
                .annualRevenue(companyDto.getAnnualRevenue())
                .status(companyDto.getStatus())
                .tags(companyDto.getTags())
                .country(companyDto.getCountry())
                .website(companyDto.getWebsite())
                .contactPerson(companyDto.getContactPerson())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .isDelete(false)
                .build();
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> update(int id, CompanyDto companyDto) {
        return companyRepository.findById(id).map(existingCompany -> {
            existingCompany.setName(companyDto.getName());
            existingCompany.setRegistrationNo(companyDto.getRegistrationNo());
            existingCompany.setTaxId(companyDto.getTaxId());
            existingCompany.setLogoUrl(companyDto.getLogoUrl());
            existingCompany.setEmail(companyDto.getEmail());
            existingCompany.setAddress(companyDto.getAddress());
            existingCompany.setIndustryType(companyDto.getIndustryType());
            existingCompany.setNoOfEmployees(companyDto.getNoOfEmployees());
            existingCompany.setCapital(companyDto.getCapital());
            existingCompany.setAnnualRevenue(companyDto.getAnnualRevenue());
            existingCompany.setStatus(companyDto.getStatus());
            existingCompany.setTags(companyDto.getTags());
            existingCompany.setCountry(companyDto.getCountry());
            existingCompany.setWebsite(companyDto.getWebsite());
            existingCompany.setContactPerson(companyDto.getContactPerson());
            existingCompany.setUpdatedDate(LocalDateTime.now());
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
