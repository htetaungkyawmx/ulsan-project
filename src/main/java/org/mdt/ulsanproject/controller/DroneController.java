package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.DroneDto;
import org.mdt.ulsanproject.model.Drone;
import org.mdt.ulsanproject.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    private final DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    // Create a new drone
//    @PostMapping
//    public ResponseEntity<Drone> createDrone(@RequestBody DroneDto droneDto) {
//        Drone savedDrone = droneService.save(droneDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedDrone);
//    }
    @PostMapping
    public ResponseEntity<String> createDrone(@RequestBody DroneDto droneDTO) {
        droneService.save(droneDTO);
        return ResponseEntity.ok("Drone created successfully!");
    }

    // Get all drones
    @GetMapping
    public ResponseEntity<List<Drone>> getAllDrones() {
        List<Drone> drones = droneService.findAll();
        return ResponseEntity.ok(drones);
    }

    // Get a drone by ID
    @GetMapping("/{id}")
    public ResponseEntity<Drone> getDroneById(@PathVariable int id) {
        return droneService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a drone
    @PutMapping("/{id}")
    public ResponseEntity<Drone> updateDrone(@PathVariable int id, @RequestBody DroneDto droneDto) {
        return droneService.update(id, droneDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a drone (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable int id) {
        if (droneService.findById(id).isPresent()) {
            droneService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
