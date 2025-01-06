package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.RoleDto;
import org.mdt.ulsanproject.model.Permission;
import org.mdt.ulsanproject.model.Role;
import org.mdt.ulsanproject.repository.PermissionRepository;
import org.mdt.ulsanproject.repository.RoleRepository;
import org.mdt.ulsanproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Role save(RoleDto roleDto) {
        // Validate role name to ensure uniqueness
        validateRoleName(roleDto.getName());

        // Fetch and assign permissions based on provided permission IDs
        Set<Permission> permissions = fetchPermissions(roleDto.getPermissionIds());

        // Ensure the role has at least one permission before saving
        if (permissions.isEmpty()) {
            throw new IllegalArgumentException("Role must have at least one permission.");
        }

        // Create and save the new role
        Role role = Role.builder()
                .name(roleDto.getName())
                .description(roleDto.getDescription())
                .permissions(permissions)
                .build();

        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> update(int id, RoleDto roleDto) {
        return roleRepository.findById(id).map(existingRole -> {
            // Update the role's name and description
            existingRole.setName(roleDto.getName());
            existingRole.setDescription(roleDto.getDescription());

            // Check if new permissions are provided and update them
            if (roleDto.getPermissionIds() != null && !roleDto.getPermissionIds().isEmpty()) {
                // Fetch and assign new permissions if provided
                existingRole.setPermissions(fetchPermissions(roleDto.getPermissionIds()));
            }

            // Save and return the updated role
            return roleRepository.save(existingRole);
        });
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role assignPermissionsToRole(int roleId, List<Integer> permissionIds) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found with ID: " + roleId));

        // Fetch and assign permissions
        Set<Permission> permissions = fetchPermissions(permissionIds);

        // Ensure the role has at least one permission before updating
        if (permissions.isEmpty()) {
            throw new IllegalArgumentException("Role must have at least one permission.");
        }

        role.setPermissions(permissions);
        return roleRepository.save(role);
    }

    // Method to validate that the role name is unique
    private void validateRoleName(String name) {
        if (roleRepository.existsByName(name)) {
            throw new IllegalArgumentException("Role with name '" + name + "' already exists.");
        }
    }

    // Method to fetch permissions based on a list of permission IDs
    private Set<Permission> fetchPermissions(List<Integer> permissionIds) {
        if (permissionIds == null || permissionIds.isEmpty()) {
            return new HashSet<>();
        }

        List<Permission> permissions = permissionRepository.findAllById(permissionIds);

        if (permissions.isEmpty()) {
            throw new IllegalArgumentException("Invalid permission IDs provided.");
        }

        return new HashSet<>(permissions);
    }
}
