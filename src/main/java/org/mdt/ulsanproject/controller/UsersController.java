package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.service.UsersService;
import org.mdt.ulsanproject.util.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UsersDto usersDto) {
        Users createdUser = usersService.save(usersDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll(@AuthenticationPrincipal String currentUserEmail) {
        if (authService.isAuthorized(currentUserEmail, "read_user")) {
            List<Users> users = usersService.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
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
                .map(updatedUser -> new ResponseEntity<>(updatedUser, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
