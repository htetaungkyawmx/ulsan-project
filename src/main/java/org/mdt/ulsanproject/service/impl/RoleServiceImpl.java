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

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Role save(RoleDto roleDto) {
        List<Permission> permissions = permissionRepository
                .findAllById(roleDto.getPermissionIds());
        if (permissions.isEmpty() && roleDto.getPermissionIds() != null) {
            throw new IllegalArgumentException("Permissions not found for the provided IDs");
        }

        Role role = Role.builder()
                .name(roleDto.getName())
                .permissions(new HashSet<>(permissions))
                .build();
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> update(int id, RoleDto roleDto) {
        return roleRepository.findById(id).map(existingRole -> {
            existingRole.setName(roleDto.getName());
            if (roleDto.getPermissionIds() != null) {
                List<Permission> permissions = permissionRepository.findAllById(roleDto.getPermissionIds());
                if (!permissions.isEmpty()) {
                    existingRole.setPermissions(new HashSet<>(permissions));
                } else {
                    throw new IllegalArgumentException("Permissions not found for the provided IDs");
                }
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
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            List<Permission> permissions = permissionRepository.findAllById(permissionIds);
            if (!permissions.isEmpty()) {
                role.setPermissions(new HashSet<>(permissions));
                return roleRepository.save(role);
            } else {
                throw new IllegalArgumentException("Permissions not found for the provided IDs");
            }
        }
        throw new IllegalArgumentException("Role not found with ID: " + roleId);
    }
}
