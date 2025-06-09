package com.cyber009.s3t2.seeder;

import com.cyber009.s3t2.service.seeder.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RolePermissionEndpointSeeder implements CommandLineRunner {

    private final EndPointSeederService endPointSeederService;
    private final PermissionSeederService permissionSeederService;
    private final PermissionHasEndPointSeederService permissionHasEndPointSeederService;
    private final RoleSeederService roleSeederService;
    private final RoleHasPermissionSeederService roleHasPermissionSeederService;

    @Override
    public void run(String... args) throws Exception {
        permissionSeederService.seedPermission();
        endPointSeederService.seedEndPoint();
        permissionHasEndPointSeederService.seedPermissionHasEndPoint();
        roleSeederService.seedRole();
        roleHasPermissionSeederService.seedRoleHasPermission();
    }


}
