package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.RoleDto;
import org.mdt.ulsanproject.model.Permission;
import org.mdt.ulsanproject.model.Role;
import org.mdt.ulsanproject.repository.RoleRepository;
import org.mdt.ulsanproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Role save(RoleDto roleDto) {
        Set<Permission> permissions = roleDto.getPermissions().stream()
                .map(permissionName -> Permission.builder().name(permissionName).build())
                .collect(Collectors.toSet());

        Role role = Role.builder()
                .name(roleDto.getName())
                .permissions(permissions)
                .build();

        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> update(int id, RoleDto roleDto) {
        return roleRepository.findById(id).map(existingRole -> {
            existingRole.setName(roleDto.getName());
            if (roleDto.getPermissions() != null) {
                Set<Permission> permissions = roleDto.getPermissions().stream()
                        .map(permissionName -> Permission.builder().name(permissionName).build())
                        .collect(Collectors.toSet());
                existingRole.setPermissions(permissions);
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
}
