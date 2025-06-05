package com.cyber009.s3t2.service;

import com.cyber009.s3t2.constance.ApiPath;
import com.cyber009.s3t2.entity.EndPointEntity;
import com.cyber009.s3t2.enums.EndPointMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EndPointSeederService {
    private final RoleService roleService;

    public void seedEndPoint() {
        log.info("Initializing Seed EndPoint");
        initEndPoint();
    }

    private void initEndPoint() {
        log.info("Initializing permissions and endpoints");
        List<EndPointEntity> permissionHasEndPointEntities = g();
        for (EndPointEntity permissionHasEndPointEntity : permissionHasEndPointEntities) {
            if(roleService.existEndPointByName(permissionHasEndPointEntity.getName())) {
                log.info("EndPoint with name {} already exists, skipping", permissionHasEndPointEntity.getName());
                continue;
            }
            roleService.savePermissionHasEndPoint(permissionHasEndPointEntity);
        }
    }

    private List<EndPointEntity> g() {
        List<EndPointEntity> permissionHasEndPointEntities = new LinkedList<>();
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_AUTH_AUTHENTICATE_POST")
                        .endPoint(ApiPath.AuthPath.API_AUTH_AUTHENTICATE)
                        .method(EndPointMethod.POST)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_AUTH_REGISTER_POST")
                        .endPoint(ApiPath.AuthPath.API_AUTH_REGISTER)
                        .method(EndPointMethod.POST)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_HOME_GET")
                        .endPoint(ApiPath.HomePath.API_HOME)
                        .method(EndPointMethod.GET)
                        .build());
        return permissionHasEndPointEntities;
    }
}
