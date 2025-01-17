package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.PilotDto;
import org.mdt.ulsanproject.service.PilotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilots/")
public class PilotController {
    private final PilotService pilotService;

    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @PostMapping
    public ResponseEntity<PilotDto> createPilot(@RequestBody PilotDto pilotDto) {
        return ResponseEntity.ok(pilotService.createPilot(pilotDto));
    }

    @GetMapping
    public ResponseEntity<List<PilotDto>> getAllPilots() {
        return ResponseEntity.ok(pilotService.getAllPilots());
    }

    @GetMapping("{id}/")
    public ResponseEntity<PilotDto> getPilotById(@PathVariable int id) {
        return ResponseEntity.ok(pilotService.getPilotById(id));
    }

    @PutMapping("{id}/")
    public ResponseEntity<PilotDto> updatePilot(@PathVariable int id, @RequestBody PilotDto pilotDto) {
        return ResponseEntity.ok(pilotService.updatePilot(id, pilotDto));
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<PilotDto> deletePilot(@PathVariable int id) {
        return ResponseEntity.ok(pilotService.deletePilot(id));
    }
}
