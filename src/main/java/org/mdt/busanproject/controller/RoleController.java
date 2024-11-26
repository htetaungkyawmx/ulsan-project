package org.mdt.busanproject.controller;

import org.mdt.busanproject.entity.Role;
import org.mdt.busanproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/create")
    public Role createRole(@RequestParam String name) {
        Role role = new Role();
        role.setName(name);
        return roleRepository.save(role);
    }
}
