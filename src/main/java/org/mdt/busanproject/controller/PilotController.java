package org.mdt.busanproject.controller;

import org.mdt.busanproject.dto.PilotDto;
import org.mdt.busanproject.model.Pilot;
import org.mdt.busanproject.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("org/pilot")
public class PilotController {

    @Autowired
    private PilotService pilotService;

    @PostMapping("/create")
    public ResponseEntity<Pilot> create(@RequestBody PilotDto pilotDto) {
        Pilot createPilot = pilotService.save(pilotDto);
        return new ResponseEntity<>(createPilot, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pilot>> getAll() {
        List<Pilot> pilots = pilotService.findAll();
        return new ResponseEntity<>(pilots, HttpStatus.OK);
    }

}
