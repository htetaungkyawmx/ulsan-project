package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.RoleDto;
import org.mdt.ulsanproject.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role save(RoleDto roleDto);
    Optional<Role> update(int id, RoleDto roleDto);
    List<Role> findAll();
    Optional<Role> findById(int id);
    void delete(int id);
    Role assignPermissionsToRole(int roleId, List<Integer> permissionIds);
}
