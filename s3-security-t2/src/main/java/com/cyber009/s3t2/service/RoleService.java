package com.cyber009.s3t2.service;

import com.cyber009.s3t2.entity.*;
import com.cyber009.s3t2.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final EndPointRepository endPointRepository;
    private final PermissionRepository permissionRepository;
    private final PermissionHasEndPointRepository permissionHasEndPointRepository;
    private final RoleHasPermissionRepository roleHasPermissionRepository;
    private final RoleRepository roleRepository;

    public void saveEndPoint(EndPointEntity endPointEntity) {
        log.info("Saving endPointEntity: {}", endPointEntity);
        endPointRepository.save(endPointEntity);
    }

    public Boolean existEndPointByName(String name) {
        log.info("Checking if EndPoint exists by name: {}", name);
        return endPointRepository.existsByName(name);
    }

    public void savePermission(PermissionEntity entity) {
        log.info("Saving PermissionEntity: {}", entity);
        permissionRepository.save(entity);
    }

    public Boolean existPermissionByName(String name) {
        log.info("Checking if Permission exists by name: {}", name);
        return permissionRepository.existsByName(name);
    }

    public void savePermissionHasEndPoint(PermissionHasEndPointEntity entity) {
        log.info("Saving Permission Has EndPoint: {}", entity);
        permissionHasEndPointRepository.save(entity);
    }

    public Boolean existPermissionHasEndpointByName(String permissionName, String endPointName) {
        log.info("Checking if Permission exists by name: {} & {}", permissionName, endPointName);
        return permissionHasEndPointRepository.existsByPermission_NameAndEndPoint_Name(permissionName, endPointName);
    }

    public void saveRoleHasPermissionRepository(RoleHasPermissionEntity entity) {
        log.info("Saving Role Has Permission: {}", entity);
        roleHasPermissionRepository.save(entity);
    }

    public Boolean existRoleHasPermissionByRoleNameAndPermission(String roleName, String permissionName) {
        log.info("Checking if RoleHasPermission exists by name: {} & {}", roleName, permissionName);
        return roleHasPermissionRepository.existsByRole_nameAndPermission_Name(roleName, permissionName);
    }

    public void saveRole(RoleEntity entity) {
        log.info("Saving RoleEntity: {}", entity);
        roleRepository.save(entity);
    }

    public Boolean existRoleByName(String name) {
        log.info("Checking if Role exists by name: {}", name);
        return roleRepository.existsByName(name);
    }

}
