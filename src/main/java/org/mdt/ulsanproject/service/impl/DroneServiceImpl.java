package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.DroneDto;
import org.mdt.ulsanproject.model.Drone;
import org.mdt.ulsanproject.repository.DroneRepository;
import org.mdt.ulsanproject.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneServiceImpl implements DroneService {
    @Autowired
    private DroneRepository droneRepository;

    @Override
    public Drone save(DroneDto droneDto) {
        Drone drone = Drone.builder()
                .model(droneDto.getModel())
                .manufacturer(droneDto.getManufacturer())
                .weight(droneDto.getWeight())
                .maxAltitude(droneDto.getMaxAltitude())
                .batteryCapacity(droneDto.getBatteryCapacity())
                .operatingRange(droneDto.getOperatingRange())
                .build();
        return droneRepository.save(drone);
    }

    @Override
    public Optional<Drone> update(int id, DroneDto droneDto) {
        return droneRepository.findById(id).map(existingDrone -> {
            existingDrone.setModel(droneDto.getModel());
            existingDrone.setManufacturer(droneDto.getManufacturer());
            existingDrone.setWeight(droneDto.getWeight());
            existingDrone.setMaxAltitude(droneDto.getMaxAltitude());
            existingDrone.setBatteryCapacity(droneDto.getBatteryCapacity());
            existingDrone.setOperatingRange(droneDto.getOperatingRange());
            return droneRepository.save(existingDrone);
        });
    }

    @Override
    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    @Override
    public Optional<Drone> findById(int id) {
        return droneRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        droneRepository.deleteById(id);
    }
}
