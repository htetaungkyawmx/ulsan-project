package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.CompanyDto;
import org.mdt.ulsanproject.model.Company;
import org.mdt.ulsanproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Company> create(@RequestBody CompanyDto companyDto) {
        Company createdCompany = companyService.save(companyDto);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAll() {
        List<Company> companies = companyService.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable int id) {
        return companyService.findById(id)
                .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
