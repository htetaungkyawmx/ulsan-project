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
                .droneModel(droneDto.getDroneModel())
                .manufacturer(droneDto.getManufacturer())
                .droneType(droneDto.getDroneType())
                .category(droneDto.getCategory())
                .weight(droneDto.getWeight())
                .maxAltitude(droneDto.getMaxAltitude())
                .batteryCapacity(droneDto.getBatteryCapacity())
                .operatingRange(droneDto.getOperatingRange())
                .droneCode(generateDroneCode(droneDto))
                .image(droneDto.getImage())
                .description(droneDto.getDescription())
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
            existingDrone.setImage(droneDto.getImage());
            existingDrone.setDescription(droneDto.getDescription());
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

    // Helper method to generate drone code
    private String generateDroneCode(DroneDto droneDto) {
        String typeCode = droneDto.getDroneType() != null ? droneDto.getDroneType().substring(0, 4).toUpperCase() : "GEN";
        String categoryCode = droneDto.getCategory() != null ? droneDto.getCategory().substring(0, 4).toUpperCase() : "GEN";
        long count = droneRepository.count(); // Get total count to generate unique code
        return String.format("%s-%s-%03d", typeCode, categoryCode, count + 1);
    }
}
