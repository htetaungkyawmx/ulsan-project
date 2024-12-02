package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.DroneDto;
import org.mdt.ulsanproject.model.Drone;

import java.util.List;
import java.util.Optional;

public interface DroneService {
    Drone save(DroneDto droneDto);
    Drone update(int id, DroneDto droneDto);
    List<Drone> findAll();
    Optional<Drone> findById(int id);
    void delete(int id);
}
