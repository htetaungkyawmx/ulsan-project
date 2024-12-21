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
                .droneId(maintenanceDto.getDroneId())
                .serialNo(maintenanceDto.getSerialNo())
                .fcVersion(maintenanceDto.getFcVersion())
                .controller(maintenanceDto.getController())
                .motor(maintenanceDto.getMotor())
                .camera(maintenanceDto.getCamera())
                .battery(maintenanceDto.getBattery())
                .charger(maintenanceDto.getCharger())
                .communicationType(maintenanceDto.getCommunicationType())
                .part1(maintenanceDto.getPart1())
                .part2(maintenanceDto.getPart2())
                .part3(maintenanceDto.getPart3())
                .part4(maintenanceDto.getPart4())
                .part5(maintenanceDto.getPart5())
                .part6(maintenanceDto.getPart6())
                .part7(maintenanceDto.getPart7())
                .part8(maintenanceDto.getPart8())
                .description(maintenanceDto.getDescription())
                .maintenanceDate(maintenanceDto.getMaintenanceDate())
                .cost(maintenanceDto.getCost())
                .isResolved(maintenanceDto.getIsResolved())
                .build();
        return maintenanceRepository.save(maintenance);
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
    public Optional<Maintenance> update(int id, MaintenanceDto maintenanceDto) {
        return maintenanceRepository.findById(id).map(existingMaintenance -> {
            existingMaintenance.setDroneId(maintenanceDto.getDroneId());
            existingMaintenance.setSerialNo(maintenanceDto.getSerialNo());
            existingMaintenance.setFcVersion(maintenanceDto.getFcVersion());
            existingMaintenance.setController(maintenanceDto.getController());
            existingMaintenance.setMotor(maintenanceDto.getMotor());
            existingMaintenance.setCamera(maintenanceDto.getCamera());
            existingMaintenance.setBattery(maintenanceDto.getBattery());
            existingMaintenance.setCharger(maintenanceDto.getCharger());
            existingMaintenance.setCommunicationType(maintenanceDto.getCommunicationType());
            existingMaintenance.setPart1(maintenanceDto.getPart1());
            existingMaintenance.setPart2(maintenanceDto.getPart2());
            existingMaintenance.setPart3(maintenanceDto.getPart3());
            existingMaintenance.setPart4(maintenanceDto.getPart4());
            existingMaintenance.setPart5(maintenanceDto.getPart5());
            existingMaintenance.setPart6(maintenanceDto.getPart6());
            existingMaintenance.setPart7(maintenanceDto.getPart7());
            existingMaintenance.setPart8(maintenanceDto.getPart8());
            existingMaintenance.setDescription(maintenanceDto.getDescription());
            existingMaintenance.setMaintenanceDate(maintenanceDto.getMaintenanceDate());
            existingMaintenance.setCost(maintenanceDto.getCost());
            existingMaintenance.setIsResolved(maintenanceDto.getIsResolved());
            return maintenanceRepository.save(existingMaintenance);
        });
    }

    @Override
    public void delete(int id) {
        maintenanceRepository.deleteById(id);
    }
}
