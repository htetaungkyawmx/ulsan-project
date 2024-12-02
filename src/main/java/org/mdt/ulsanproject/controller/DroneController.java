package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.DroneDto;
import org.mdt.ulsanproject.model.Drone;
import org.mdt.ulsanproject.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DroneController {
    @Autowired
    private DroneService droneService;

    @PostMapping("/create")
    public ResponseEntity<Drone> create(@RequestBody DroneDto droneDto) {
        Drone createdDrone = droneService.save(droneDto);
        return new ResponseEntity<>(createdDrone, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Drone>> getAll() {
        List<Drone> drones = droneService.findAll();
        return new ResponseEntity<>(drones, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drone> update(@PathVariable int id) {
        return droneService.findById(id)
                .map(drone -> new ResponseEntity<>(drone, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        droneService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
