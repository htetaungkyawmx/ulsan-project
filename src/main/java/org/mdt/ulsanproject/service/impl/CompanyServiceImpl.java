package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl {
    @Autowired
    private CompanyRepository companyRepository;

}
