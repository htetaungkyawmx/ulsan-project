package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.HelpCenterDto;
import org.mdt.ulsanproject.model.HelpCenter;
import org.mdt.ulsanproject.service.HelpCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelpCenterController {
    @Autowired
    private HelpCenterService helpCenterService;

    @PostMapping("/create")
    public ResponseEntity<HelpCenter> create(@RequestBody HelpCenterDto helpCenterDto) {
        HelpCenter createdHelpCenter = helpCenterService.save(helpCenterDto);
        return new ResponseEntity<>(createdHelpCenter, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HelpCenter>> getAll() {
        List<HelpCenter> helpCenters = helpCenterService.findAll();
        return new ResponseEntity<>(helpCenters, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HelpCenter> update(@PathVariable int id) {
        return helpCenterService.findById(id)
                .map(helpCenter -> new ResponseEntity<>(helpCenter, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        helpCenterService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
