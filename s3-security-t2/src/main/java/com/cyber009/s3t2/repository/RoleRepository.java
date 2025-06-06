package com.cyber009.s3t2.repository;

import com.cyber009.s3t2.entity.RoleEntity;
import com.cyber009.s3t2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Boolean existsByName(String name);
}