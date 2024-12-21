package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    boolean existsByName(String name); // Check for duplicate permissions by name
}
