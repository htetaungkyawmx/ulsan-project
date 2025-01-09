package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.PermissionDto;
import org.mdt.ulsanproject.model.Permission;
import org.mdt.ulsanproject.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody PermissionDto permissionDto) {
        Permission createdPermission = permissionService.save(permissionDto);
        return new ResponseEntity<>(createdPermission, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        List<Permission> permissions = permissionService.findAll();
        return new ResponseEntity<>(permissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable int id) {
        Optional<Permission> permission = permissionService.findById(id);
        return permission.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable int id, @RequestBody PermissionDto permissionDto) {
        Optional<Permission> updatedPermission = permissionService.update(id, permissionDto);
        return updatedPermission.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable int id) {
        permissionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
