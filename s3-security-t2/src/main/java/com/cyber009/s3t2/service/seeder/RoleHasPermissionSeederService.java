package com.cyber009.s3t2.service.seeder;

import com.cyber009.s3t2.entity.PermissionEntity;
import com.cyber009.s3t2.entity.RoleEntity;
import com.cyber009.s3t2.entity.RoleHasPermissionEntity;
import com.cyber009.s3t2.repository.PermissionRepository;
import com.cyber009.s3t2.repository.RoleRepository;
import com.cyber009.s3t2.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleHasPermissionSeederService {
    private final RoleService roleService;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public void seedRoleHasPermission() {
        log.info("Initializing Seed RoleHasPermission");
        initRoleHasPermission();
    }

    private void initRoleHasPermission() {
        log.info("Initializing RoleHasPermission");
        List<RoleNameHasPermissionName> entities = g();
        for (RoleNameHasPermissionName e : entities) {
            log.info("e: {} {}", e.roleName, e.permissionName);
            if(roleService.existRoleHasPermissionByRoleNameAndPermission(e.roleName, e.permissionName)) {
                log.info("`Role-Permission` already exists: {} {}", e.roleName, e.permissionName);
                continue;
            }
            Optional<RoleEntity> opRoleEntity = roleRepository.findOneByName(e.roleName);
            Optional<PermissionEntity> opPermissionEntity = permissionRepository.findOneByName(e.permissionName);
            if(opRoleEntity.isEmpty() || opPermissionEntity.isEmpty()) {
                log.error("Role or Permission not found for: {} {}", e.roleName, e.permissionName);
                continue;
            }
            RoleHasPermissionEntity entity = RoleHasPermissionEntity.builder()
                    .role(opRoleEntity.get())
                    .permission(opPermissionEntity.get())
                    .build();
            roleService.saveRoleHasPermissionRepository(entity);
        }
    }

    private List<RoleNameHasPermissionName> g() {
        List<RoleNameHasPermissionName> entities = new LinkedList<>();
        entities.add(new RoleNameHasPermissionName("Register", "REGISTER"));
        entities.add(new RoleNameHasPermissionName("Home", "HOME"));
        return entities;
    }

    record RoleNameHasPermissionName(String roleName, String permissionName) {}
}
