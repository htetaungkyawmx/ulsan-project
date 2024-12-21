package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.PermissionDto;
import org.mdt.ulsanproject.model.Permission;
import org.mdt.ulsanproject.repository.PermissionRepository;
import org.mdt.ulsanproject.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    // Save a new permission
    @Override
    public Permission save(PermissionDto permissionDto) {
        if (permissionRepository.existsByName(permissionDto.getName())) {
            throw new IllegalArgumentException("Permission with this name already exists");
        }
        Permission permission = Permission.builder()
                .name(permissionDto.getName())
                .description(permissionDto.getDescription())
                .build();
        return permissionRepository.save(permission);
    }

    // Update an existing permission
    @Override
    public Optional<Permission> update(int id, PermissionDto permissionDto) {
        return permissionRepository.findById(id).map(existingPermission -> {
            existingPermission.setName(permissionDto.getName());
            existingPermission.setDescription(permissionDto.getDescription());
            return permissionRepository.save(existingPermission);
        });
    }

    // Retrieve all permissions
    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    // Retrieve a permission by ID
    @Override
    public Optional<Permission> findById(int id) {
        return permissionRepository.findById(id);
    }

    // Delete a permission by ID
    @Override
    public void delete(int id) {
        if (!permissionRepository.existsById(id)) {
            throw new IllegalArgumentException("Permission not found with ID: " + id);
        }
        permissionRepository.deleteById(id);
    }
}
