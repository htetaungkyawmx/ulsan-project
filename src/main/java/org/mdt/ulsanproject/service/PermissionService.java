package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.PermissionDto;
import org.mdt.ulsanproject.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    Permission save(PermissionDto permissionDto);
    Optional<Permission> update(int id, PermissionDto permissionDto);
    List<Permission> findAll();
    Optional<Permission> findById(int id);
    void delete(int id);
}
