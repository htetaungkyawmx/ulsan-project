package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}
