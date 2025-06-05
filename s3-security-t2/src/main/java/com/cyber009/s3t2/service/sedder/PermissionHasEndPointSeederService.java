package com.cyber009.s3t2.service.sedder;

import com.cyber009.s3t2.entity.EndPointEntity;
import com.cyber009.s3t2.entity.PermissionEntity;
import com.cyber009.s3t2.entity.PermissionHasEndPointEntity;
import com.cyber009.s3t2.repository.EndPointRepository;
import com.cyber009.s3t2.repository.PermissionRepository;
import com.cyber009.s3t2.service.RoleService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionHasEndPointSeederService {
    private final RoleService roleService;
    private final PermissionRepository permissionRepository;
    private final EndPointRepository endPointRepository;

    public void seedPermissionHasEndPoint() {
        log.info("Initializing Seed PermissionHasEndPoint");
        initPermissionHasEndPoint();
    }

    private void initPermissionHasEndPoint() {
        log.info("Initializing PermissionHasEndPoint");
        List<PermissionNameHasEndPointName> entities = g();
        for (PermissionNameHasEndPointName e : entities) {
            log.info("e: {} {}", e.permissionName, e.endPointName);
            if(roleService.existPermissionHasEndpointByName(e.permissionName, e.endPointName)) {
                log.info("PermissionHasEndPoint already exists: {} {}", e.permissionName, e.endPointName);
                continue;
            }
            Optional<PermissionEntity> opPermissionEntity = permissionRepository.findOneByName(e.permissionName);
            Optional<EndPointEntity> opEndPointEntity = endPointRepository.findOneByName(e.endPointName);
            if(opEndPointEntity.isEmpty() || opPermissionEntity.isEmpty()) {
                log.error("EndPoint or Permission not found for: {} {}", e.endPointName, e.permissionName);
                continue;
            }
            PermissionHasEndPointEntity permissionHasEndPointEntity = PermissionHasEndPointEntity.builder()
                    .permission(opPermissionEntity.get())
                    .endPoint(opEndPointEntity.get())
                    .build();
            roleService.savePermissionHasEndPoint(permissionHasEndPointEntity);
        }
    }

    private List<PermissionNameHasEndPointName> g() {
        List<PermissionNameHasEndPointName> entities = new LinkedList<>();
        entities.add(new PermissionNameHasEndPointName("REGISTER", "API_AUTH_REGISTER_POST"));
        return entities;
    }

    record PermissionNameHasEndPointName(String permissionName, String endPointName) {}
}
