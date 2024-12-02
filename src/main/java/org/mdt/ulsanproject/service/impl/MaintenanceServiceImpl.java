package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.MaintenanceDto;
import org.mdt.ulsanproject.model.Maintenance;
import org.mdt.ulsanproject.repository.MaintenanceRepository;
import org.mdt.ulsanproject.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance save(MaintenanceDto maintenanceDto) {
        Maintenance maintenance = Maintenance.builder()
                .drone_id(maintenanceDto.getDrone_id())
                .description(maintenanceDto.getDescription())
                .date(maintenanceDto.getDate())
                .cost(maintenanceDto.getCost())
                .build();
        return null;
    }

    @Override
    public Maintenance update(int id, MaintenanceDto maintenanceDto) {

        return null;
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Optional<Maintenance> findById(int id) {
        return maintenanceRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        maintenanceRepository.deleteById(id);
    }

}
