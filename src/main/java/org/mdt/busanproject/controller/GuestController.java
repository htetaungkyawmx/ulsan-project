package org.mdt.busanproject.controller;

import org.mdt.aioceaneye.dto.GuestDto;
import org.mdt.aioceaneye.model.Guest;
import org.mdt.aioceaneye.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("org/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/create")
    public ResponseEntity<Guest> create(@RequestBody GuestDto guestDto) {
        Guest createGuest = guestService.save(guestDto);
        return new ResponseEntity<>(createGuest, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Guest>> getAll() {
        List<Guest> guests = guestService.findAll();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

}
