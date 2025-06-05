package com.cyber009.s3t2.repository;

import com.cyber009.s3t2.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {
    Boolean existsByName(String name);
    Optional<PermissionEntity> findOneByName(String name);
}