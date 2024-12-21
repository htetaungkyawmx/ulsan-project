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
        validateRoleName(roleDto.getName());
        Role role = Role.builder()
                .name(roleDto.getName())
                .description(roleDto.getDescription())
                .permissions(fetchPermissions(roleDto.getPermissionIds()))
                .build();
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> update(int id, RoleDto roleDto) {
        return roleRepository.findById(id).map(existingRole -> {
            existingRole.setName(roleDto.getName());
            existingRole.setDescription(roleDto.getDescription());
            if (roleDto.getPermissionIds() != null) {
                existingRole.setPermissions(fetchPermissions(roleDto.getPermissionIds()));
            }
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
        role.setPermissions(fetchPermissions(permissionIds));
        return roleRepository.save(role);
    }

    private void validateRoleName(String name) {
        if (roleRepository.existsByName(name)) {
            throw new IllegalArgumentException("Role with name '" + name + "' already exists.");
        }
    }

    private Set<Permission> fetchPermissions(List<Integer> permissionIds) {
        List<Permission> permissions = permissionRepository.findAllById(permissionIds);
        if (permissions.isEmpty() && !permissionIds.isEmpty()) {
            throw new IllegalArgumentException("Invalid permission IDs provided.");
        }
        return new HashSet<>(permissions);
    }
}
