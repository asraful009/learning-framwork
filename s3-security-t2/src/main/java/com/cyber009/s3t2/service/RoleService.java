package com.cyber009.s3t2.service;

import com.cyber009.s3t2.entity.PermissionHasEndPointEntity;
import com.cyber009.s3t2.repository.PermissionHasEndPointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {
    private final PermissionHasEndPointRepository permissionHasEndPointRepository;

    public PermissionHasEndPointEntity savePermissionHasEndPoint(PermissionHasEndPointEntity permissionHasEndPointEntity) {
        log.info("Saving PermissionHasEndPoint: {}", permissionHasEndPointEntity);
        return permissionHasEndPointRepository.save(permissionHasEndPointEntity);
    }
}
