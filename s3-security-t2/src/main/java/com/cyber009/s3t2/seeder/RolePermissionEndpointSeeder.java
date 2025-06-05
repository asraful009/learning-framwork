package com.cyber009.s3t2.seeder;

import com.cyber009.s3t2.constance.ApiPath;
import com.cyber009.s3t2.entity.EndPointEntity;
import com.cyber009.s3t2.enums.EndPointMethod;
import com.cyber009.s3t2.service.EndPointSeederService;
import com.cyber009.s3t2.service.PermissionSeederService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class RolePermissionEndpointSeeder implements CommandLineRunner {

    private final EndPointSeederService endPointSeederService;
    private final PermissionSeederService permissionSeederService;

    @Override
    public void run(String... args) throws Exception {
        endPointSeederService.seedEndPoint();
        permissionSeederService.seedPermission();
    }


}
