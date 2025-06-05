package com.cyber009.s3t2.service.sedder;

import com.cyber009.s3t2.entity.PermissionHasEndPointEntity;
import com.cyber009.s3t2.service.RoleService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionHasEndPointSeederService {
    private final RoleService roleService;

    public void seedPermissionHasEndPoint() {
        log.info("Initializing Seed PermissionHasEndPoint");
        initPermissionHasEndPoint();
    }

    private void initPermissionHasEndPoint() {
        log.info("Initializing PermissionHasEndPoint");
        List<PermissionNameHasEndPointName> entities = g();
        for (PermissionNameHasEndPointName e : entities) {
            log.info("e: {} {}", e.permissionName, e.endPointName);
        }
    }

    private List<PermissionNameHasEndPointName> g() {
        List<PermissionNameHasEndPointName> entities = new LinkedList<>();
        entities.add(new PermissionNameHasEndPointName("REGISTER", "API_AUTH_REGISTER_POST"));
        return entities;
    }

    record PermissionNameHasEndPointName(String permissionName, String endPointName) {}
}
