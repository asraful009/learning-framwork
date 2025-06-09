package com.cyber009.s3t2.repository;

import com.cyber009.s3t2.entity.RoleHasPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleHasPermissionRepository extends JpaRepository<RoleHasPermissionEntity, Integer> {
    Boolean existsByRole_nameAndPermission_Name(String roleName, String permissionName);
}