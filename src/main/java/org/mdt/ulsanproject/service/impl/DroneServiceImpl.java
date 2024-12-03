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
    public Drone update(int id, DroneDto droneDto) {
        Optional<Drone> existingDrone = droneRepository.findById(id);
        if (existingDrone.isPresent()) {
            Drone droneToUpdate = existingDrone.get();
            droneToUpdate.setModel(droneDto.getModel());
            droneToUpdate.setManufacturer(droneDto.getManufacturer());
            droneToUpdate.setWeight(droneDto.getWeight());
            droneToUpdate.setMaxAltitude(droneDto.getMaxAltitude());
            droneToUpdate.setBatteryCapacity(droneDto.getBatteryCapacity());
            droneToUpdate.setOperatingRange(droneDto.getOperatingRange());
            return droneRepository.save(droneToUpdate);
        }
        return null;
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
