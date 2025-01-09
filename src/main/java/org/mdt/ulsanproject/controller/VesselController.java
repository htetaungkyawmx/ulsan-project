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
@RequestMapping("/api/vessel")
public class VesselController {

    @Autowired
    private VesselService vesselService;

    @PostMapping
    public ResponseEntity<Vessel> create(@RequestBody VesselDto vesselDto) {
        Vessel createdVessel = vesselService.save(vesselDto);
        return new ResponseEntity<>(createdVessel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vessel>> getAll() {
        List<Vessel> vessels = vesselService.findAll();
        return new ResponseEntity<>(vessels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vessel> getById(@PathVariable int id) {
        return vesselService.findById(id)
                .map(vessel -> new ResponseEntity<>(vessel, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vessel> update(@PathVariable int id, @RequestBody VesselDto vesselDto) {
        return vesselService.update(id, vesselDto)
                .map(updatedVessel -> new ResponseEntity<>(updatedVessel, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        vesselService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
