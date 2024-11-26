package org.mdt.busanproject.repository;

import org.mdt.busanproject.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
