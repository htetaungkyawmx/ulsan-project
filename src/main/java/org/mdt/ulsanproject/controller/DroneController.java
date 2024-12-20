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

    @Autowired
    private DroneService droneService;

    // Create a new drone
    @PostMapping
    public ResponseEntity<Drone> createDrone(@RequestBody DroneDto droneDto) {
        Drone savedDrone = droneService.save(droneDto);
        return new ResponseEntity<>(savedDrone, HttpStatus.CREATED);
    }

    // Get all drones
    @GetMapping
    public List<Drone> getAllDrones() {
        return droneService.findAll();
    }

    // Get a drone by ID
    @GetMapping("/{id}")
    public ResponseEntity<Drone> getDroneById(@PathVariable int id) {
        Optional<Drone> drone = droneService.findById(id);
        return drone.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a drone
    @PutMapping("/{id}")
    public ResponseEntity<Drone> updateDrone(@PathVariable int id, @RequestBody DroneDto droneDto) {
        Optional<Drone> updatedDrone = droneService.update(id, droneDto);
        return updatedDrone.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a drone
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable int id) {
        Optional<Drone> drone = droneService.findById(id);
        if (drone.isPresent()) {
            droneService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
