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

    @Override
    public Permission save(PermissionDto permissionDto) {
        Permission permission = Permission.builder()
                .name(permissionDto.getName())
                .build();
        return permissionRepository.save(permission);
    }

    @Override
    public Optional<Permission> update(int id, PermissionDto permissionDto) {
        return permissionRepository.findById(id).map(existingPermission -> {
            existingPermission.setName(permissionDto.getName());
            return permissionRepository.save(existingPermission);
        });
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Optional<Permission> findById(int id) {
        return permissionRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        permissionRepository.deleteById(id);
    }
}
