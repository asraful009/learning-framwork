package com.cyber009.s3t2.service;

import com.cyber009.s3t2.entity.EndPointEntity;
import com.cyber009.s3t2.entity.PermissionEntity;
import com.cyber009.s3t2.entity.PermissionHasEndPointEntity;
import com.cyber009.s3t2.repository.EndPointRepository;
import com.cyber009.s3t2.repository.PermissionHasEndPointRepository;
import com.cyber009.s3t2.repository.PermissionRepository;
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

}
