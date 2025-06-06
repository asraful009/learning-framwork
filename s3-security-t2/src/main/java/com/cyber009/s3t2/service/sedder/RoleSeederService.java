package com.cyber009.s3t2.service.sedder;

import com.cyber009.s3t2.entity.RoleEntity;
import com.cyber009.s3t2.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleSeederService {
    private final RoleService roleService;

    public void seedRole() {
        log.info("Initializing Seed Role");
        initRole();
    }

    private void initRole() {
        log.info("Initializing Role");
        List<RoleEntity> entities = g();
        for (RoleEntity entity : entities) {
            if(roleService.existRoleByName(entity.getName())) {
                log.info("Role with name {} already exists, skipping", entity.getName());
                continue;
            }
            roleService.saveRole(entity);
        }
    }

    private List<RoleEntity> g() {
        List<RoleEntity> entities = new LinkedList<>();
        entities.add(
                RoleEntity.builder()
                        .name("Register")
                        .build());
        entities.add(
                RoleEntity.builder()
                        .name("Home")
                        .build());
        return entities;
    }
}
