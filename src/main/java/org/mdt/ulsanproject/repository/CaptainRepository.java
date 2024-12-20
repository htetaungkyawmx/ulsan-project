package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaptainRepository extends JpaRepository<Captain, Integer> {
    Optional<Captain> findByLicenseNumber(String licenseNumber);
    Optional<Captain> findByIdAndIsDeleteFalse(int id);
}
