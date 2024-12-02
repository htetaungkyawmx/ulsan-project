package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.MaintenanceDto;
import org.mdt.ulsanproject.model.Maintenance;
import org.mdt.ulsanproject.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping("/create")
    public ResponseEntity<Maintenance> create(@RequestBody MaintenanceDto maintenanceDto) {
        Maintenance createdMaintenance = maintenanceService.save(maintenanceDto);
        return new ResponseEntity<>(createdMaintenance, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Maintenance>> getAll() {
        List<Maintenance> maintenances = maintenanceService.findAll();
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable int id) {
        return maintenanceService.findById(id)
                .map(maintenance -> new ResponseEntity<>(maintenance, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        maintenanceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
