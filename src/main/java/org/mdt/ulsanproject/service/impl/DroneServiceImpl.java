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

    private final DroneRepository droneRepository;

    @Autowired
    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public Drone save(DroneDto droneDto) {
        // Ensure droneCode is set, either from DTO or generate
        Drone drone = Drone.builder()
                .droneCode(droneDto.getDroneCode())  // Ensure you have this field in DroneDto
                .droneModel(droneDto.getDroneModel())
                .manufacturer(droneDto.getManufacturer())
                .droneType(droneDto.getDroneType())
                .category(droneDto.getCategory())
                .weight(droneDto.getWeight())
                .maxAltitude(droneDto.getMaxAltitude())
                .batteryCapacity(droneDto.getBatteryCapacity())
                .operatingRange(droneDto.getOperatingRange())
                .serialNo(droneDto.getSerialNo())
                .controller(droneDto.getController())
                .motor(droneDto.getMotor())
                .camera(droneDto.getCamera())
                .battery(droneDto.getBattery())
                .charger(droneDto.getCharger())
                .communicationType(droneDto.getCommunicationType())
                .image(droneDto.getImage())
                .description(droneDto.getDescription())
                .isDelete(droneDto.isDelete())
                .build();
        return droneRepository.save(drone);
    }


    @Override
    public Optional<Drone> update(int id, DroneDto droneDto) {
        return droneRepository.findById(id).map(existingDrone -> {
            existingDrone.setDroneModel(droneDto.getDroneModel());
            existingDrone.setManufacturer(droneDto.getManufacturer());
            existingDrone.setDroneType(droneDto.getDroneType());
            existingDrone.setCategory(droneDto.getCategory());
            existingDrone.setWeight(droneDto.getWeight());
            existingDrone.setMaxAltitude(droneDto.getMaxAltitude());
            existingDrone.setBatteryCapacity(droneDto.getBatteryCapacity());
            existingDrone.setOperatingRange(droneDto.getOperatingRange());
            existingDrone.setSerialNo(droneDto.getSerialNo()); // Added field
            existingDrone.setController(droneDto.getController()); // Added field
            existingDrone.setMotor(droneDto.getMotor()); // Added field
            existingDrone.setCamera(droneDto.getCamera()); // Added field
            existingDrone.setBattery(droneDto.getBattery()); // Added field
            existingDrone.setCharger(droneDto.getCharger()); // Added field
            existingDrone.setCommunicationType(droneDto.getCommunicationType()); // Added field
            existingDrone.setImage(droneDto.getImage());
            existingDrone.setDescription(droneDto.getDescription());
            existingDrone.setDelete(droneDto.isDelete()); // Soft delete
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
        Optional<Drone> droneOptional = droneRepository.findById(id);
        if (droneOptional.isPresent()) {
            Drone drone = droneOptional.get();
            drone.setDelete(true); // Soft delete
            droneRepository.save(drone);
        }
    }
}
