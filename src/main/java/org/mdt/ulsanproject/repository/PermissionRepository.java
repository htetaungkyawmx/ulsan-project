package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Set<Permission> findAllByIdIn(Set<Integer> ids);
}
