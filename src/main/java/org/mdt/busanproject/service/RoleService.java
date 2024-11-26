package org.mdt.busanproject.service;

import org.mdt.busanproject.entity.Permission;
import org.mdt.busanproject.entity.Role;
import org.mdt.busanproject.repository.PermissionRepository;
import org.mdt.busanproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public Role createRole(String name, Set<String> permissionNames) {
        // Fetch permissions based on names
        Set<Permission> permissions = permissionNames.stream()
                .map(permissionName -> permissionRepository.findByName(permissionName)
                        .orElseThrow(() -> new RuntimeException("Permission not found: " + permissionName)))
                .collect(Collectors.toSet());

        // Create and save the role
        Role role = new Role();
        role.setName(name);
        role.setPermissions(permissions);
        return roleRepository.save(role);
    }
}
