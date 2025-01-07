package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.FlightLogDto;
import org.mdt.ulsanproject.model.FlightLog;
import org.mdt.ulsanproject.service.FlightLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight_log")
public class FlightLogController {
    @Autowired
    private FlightLogService flightLogService;

    @PostMapping
    public ResponseEntity<FlightLog> create(@RequestBody FlightLogDto flightLogDto) {
        FlightLog createdFlightLog = flightLogService.save(flightLogDto);
        return new ResponseEntity<>(createdFlightLog, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FlightLog>> getAll() {
        List<FlightLog> flightLogs = flightLogService.findAll();
        return new ResponseEntity<>(flightLogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightLog> getById(@PathVariable Long id) {  // Changed to Long
        return flightLogService.findById(id)
                .map(flightLog -> new ResponseEntity<>(flightLog, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightLog> update(@PathVariable Long id, @RequestBody FlightLogDto flightLogDto) {  // Changed to Long
        return flightLogService.update(Math.toIntExact(id), flightLogDto)
                .map(updateFlightLog -> new ResponseEntity<>(updateFlightLog, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {  // Changed to Long
        flightLogService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
