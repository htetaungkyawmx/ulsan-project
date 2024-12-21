package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {
    boolean existsBySerialNumberOrPassportNo(String serialNumber, String passportNo);
}
