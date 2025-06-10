package com.cyber009.s3t2.repository;

import com.cyber009.s3t2.entity.RoleHasPermissionEntity;
import com.cyber009.s3t2.entity.UserHasRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHasRoleRepository extends JpaRepository<UserHasRoleEntity, Integer> {
    Boolean existsByUser_EmailAndRole_Name(String email, String roleName);
    List<UserHasRoleEntity> findAllByUserId(Integer userId);
}