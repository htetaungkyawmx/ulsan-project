package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.MaintenanceDto;
import org.mdt.ulsanproject.model.Maintenance;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {
    Maintenance save(MaintenanceDto maintenanceDto);

    List<Maintenance> findAll();

    Optional<Maintenance> findById(int id);

    Optional<Maintenance> update(int id, MaintenanceDto maintenanceDto);

    void delete(int id);
}
