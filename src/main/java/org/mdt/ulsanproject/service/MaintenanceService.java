package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.MaintenanceDto;
import org.mdt.ulsanproject.model.Maintenance;

import java.util.List;

public interface MaintenanceService {
    Maintenance save(MaintenanceDto maintenanceDto);
    Maintenance update(int id, MaintenanceDto maintenanceDto);
    List<Maintenance> findAll();
    void delete(int id);
}
