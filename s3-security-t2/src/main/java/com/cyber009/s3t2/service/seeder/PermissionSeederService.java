package com.cyber009.s3t2.service.seeder;

import com.cyber009.s3t2.entity.PermissionEntity;
import com.cyber009.s3t2.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionSeederService {
    private final RoleService roleService;

    public void seedPermission() {
        log.info("Initializing Seed Permission");
        initPermission();
    }

    private void initPermission() {
        log.info("Initializing permissions and Permission");
        List<PermissionEntity> entities = g();
        for (PermissionEntity entity : entities) {
            if(roleService.existPermissionByName(entity.getName())) {
                log.info("Permission with name {} already exists, skipping", entity.getName());
                continue;
            }
            roleService.savePermission(entity);
        }
    }

    private List<PermissionEntity> g() {
        List<PermissionEntity> entities = new LinkedList<>();
        entities.add(
                PermissionEntity.builder()
                        .name("REGISTER")
                        .build());
        entities.add(
                PermissionEntity.builder()
                        .name("AUTHENTICATE")
                        .build());
        entities.add(
                PermissionEntity.builder()
                        .name("HOME")
                        .build());
        return entities;
    }
}
