package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.DroneDto;
import org.mdt.ulsanproject.model.Drone;
import org.mdt.ulsanproject.repository.DroneRepository;
import org.mdt.ulsanproject.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {
    @Autowired
    private DroneRepository droneRepository;

    @Override
    public Drone save(DroneDto droneDto) {
        return null;
    }

    @Override
    public Drone update(int id, DroneDto droneDto) {
        return null;
    }

    @Override
    public List<Drone> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

}
