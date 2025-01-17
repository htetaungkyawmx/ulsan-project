package org.mdt.ulsanproject.controller;

import jakarta.validation.Valid;
import org.mdt.ulsanproject.dto.AssignPermissionsDto;
import org.mdt.ulsanproject.dto.RoleDto;
import org.mdt.ulsanproject.model.Role;
import org.mdt.ulsanproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@Valid @RequestBody RoleDto roleDto) {
        Role role = roleService.save(roleDto);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("{id}/")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        return roleService.findById(id)
                .map(role -> new ResponseEntity<>(role, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}/")
    public ResponseEntity<Role> updateRole(@PathVariable Integer id, @Valid @RequestBody RoleDto roleDto) {
        return roleService.update(id, roleDto)
                .map(updatedRole -> new ResponseEntity<>(updatedRole, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{roleId}/permissions/")
    public ResponseEntity<Role> assignPermissionsToRole(
            @PathVariable Integer roleId,
            @RequestBody AssignPermissionsDto assignPermissionsDto
    ) {
        Role role = roleService.assignPermissionsToRole(roleId, assignPermissionsDto.getPermissionIds());
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
