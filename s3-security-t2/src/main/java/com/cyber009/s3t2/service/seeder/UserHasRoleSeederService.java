package com.cyber009.s3t2.service.seeder;

import com.cyber009.s3t2.entity.*;
import com.cyber009.s3t2.repository.PermissionRepository;
import com.cyber009.s3t2.repository.RoleRepository;
import com.cyber009.s3t2.repository.UserRepository;
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
public class UserHasRoleSeederService {
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public void seedUserHasRole() {
        log.info("Initializing Seed UserHasRole");
        initUserHasRole();
    }

    private void initUserHasRole() {
        log.info("Initializing UserHasRole");
        List<UserEmailHasRoleName> entities = g();
        for (UserEmailHasRoleName e : entities) {
            log.info("e: {} {}", e.email, e.role);
            if(roleService.existUserHasPermissionByUserEmailAndRoleName(e.email, e.role)) {
                log.info("`Role-Permission` already exists: {} {}", e.email, e.role);
                continue;
            }
            Optional<UserEntity> opUserEntity = userRepository.findByEmail(e.email);
            Optional<RoleEntity> opRoleEntity = roleRepository.findOneByName(e.role);
            if(opRoleEntity.isEmpty() || opUserEntity.isEmpty()) {
                log.error("Role or USer not found for: {} {}", e.role, e.email);
                continue;
            }
            UserHasRoleEntity entity = UserHasRoleEntity.builder()
                    .user(opUserEntity.get())
                    .role(opRoleEntity.get())
                    .build();
            roleService.saveUserHasRoleRepository(entity);
        }
    }

    private List<UserEmailHasRoleName> g() {
        List<UserEmailHasRoleName> entities = new LinkedList<>();
        List<UserEntity> users = userRepository.findAll();
        if(users.isEmpty()) {
            log.warn("No users found in the database. Please create users before seeding roles.");
            return entities;
        }
        for (UserEntity user : users) {
            String email = user.getEmail();

            entities.add(new UserEmailHasRoleName(email, "REGISTER"));
            entities.add(new UserEmailHasRoleName(email, "HOME"));
        }

        return entities;
    }

    record UserEmailHasRoleName(String email, String role) {}
}
