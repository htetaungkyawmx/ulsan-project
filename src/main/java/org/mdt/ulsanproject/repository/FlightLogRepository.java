package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.FlightLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightLogRepository extends JpaRepository<FlightLog, Long> {
    // Custom query methods can be added here if necessary
}
