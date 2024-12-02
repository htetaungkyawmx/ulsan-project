package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.MaintenanceDto;
import org.mdt.ulsanproject.model.Maintenance;
import org.mdt.ulsanproject.repository.MaintenanceRepository;
import org.mdt.ulsanproject.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance save(MaintenanceDto maintenanceDto) {
        return null;
    }

    @Override
    public Maintenance update(int id, MaintenanceDto maintenanceDto) {
        return null;
    }

    @Override
    public List<Maintenance> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

}
