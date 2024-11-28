package org.mdt.busanproject.repository;

import org.mdt.aioceaneye.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByEmail(String email);
}
