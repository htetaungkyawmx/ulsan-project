package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.CaptainBaseDTO;
import org.mdt.ulsanproject.model.Captain;
import org.mdt.ulsanproject.service.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/captains")
public class CaptainController {

    @Autowired
    private CaptainService captainService;

    @PostMapping
    public ResponseEntity<Captain> createCaptain(@RequestBody CaptainBaseDTO captainBaseDTO) {
        Captain newCaptain = captainService.createCaptain(captainBaseDTO);
        return ResponseEntity.ok(newCaptain);
    }

    @GetMapping
    public ResponseEntity<List<Captain>> getCaptains() {
        return ResponseEntity.ok(captainService.getAllCaptains());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Captain> getCaptainById(@PathVariable int id) {
        return ResponseEntity.ok(captainService.getCaptainById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Captain> updateCaptain(@PathVariable int id, @RequestBody CaptainBaseDTO captainBaseDTO) {
        return ResponseEntity.ok(captainService.updateCaptain(id, captainBaseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Captain> deleteCaptain(@PathVariable int id) {
        return ResponseEntity.ok(captainService.deleteCaptain(id));
    }
}
