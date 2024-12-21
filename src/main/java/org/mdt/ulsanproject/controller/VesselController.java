package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.VesselDto;
import org.mdt.ulsanproject.model.Vessel;
import org.mdt.ulsanproject.service.VesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vessel")
public class VesselController {

    @Autowired
    private VesselService vesselService;

    // Create Vessel
    @PostMapping
    public ResponseEntity<Vessel> create(@RequestBody VesselDto vesselDto) {
        Vessel createdVessel = vesselService.save(vesselDto);
        return new ResponseEntity<>(createdVessel, HttpStatus.CREATED);
    }

    // Get all vessels
    @GetMapping
    public ResponseEntity<List<Vessel>> getAll() {
        List<Vessel> vessels = vesselService.findAll();
        return new ResponseEntity<>(vessels, HttpStatus.OK);
    }

    // Get vessel by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vessel> getById(@PathVariable int id) {
        return vesselService.findById(id)
                .map(vessel -> new ResponseEntity<>(vessel, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update vessel by ID
    @PutMapping("/{id}")
    public ResponseEntity<Vessel> update(@PathVariable int id, @RequestBody VesselDto vesselDto) {
        return vesselService.update(id, vesselDto)
                .map(updatedVessel -> new ResponseEntity<>(updatedVessel, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete vessel by ID (Logical delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        vesselService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
