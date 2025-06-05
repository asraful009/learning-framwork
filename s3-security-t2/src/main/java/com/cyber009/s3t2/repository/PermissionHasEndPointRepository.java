package com.cyber009.s3t2.repository;

import com.cyber009.s3t2.entity.PermissionHasEndPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionHasEndPointRepository extends JpaRepository<PermissionHasEndPointEntity, Integer> {
    Boolean existsByPermission_NameAndEndPoint_Name(String permissionName, String endPointName);
}