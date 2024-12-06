package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UsersDto usersDto) {
        Users createdUsers = usersService.save(usersDto);
        return new ResponseEntity<>(createdUsers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        List<Users> users = usersService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable int id) {
        return usersService.findById(id)
                .map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable int id, @RequestBody UsersDto usersDto) {
        return usersService.update(id, usersDto)
                .map(updatedUsers -> new ResponseEntity<>(updatedUsers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
