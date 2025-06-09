package com.cyber009.s3t2.service.seeder;

import com.cyber009.s3t2.constance.ApiPath;
import com.cyber009.s3t2.entity.EndPointEntity;
import com.cyber009.s3t2.enums.EndPointMethod;
import com.cyber009.s3t2.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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
            roleService.saveEndPoint(permissionHasEndPointEntity);
        }
    }

    private List<EndPointEntity> g() {
        List<EndPointEntity> permissionHasEndPointEntities = new LinkedList<>();
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_AUTH_AUTHENTICATE_POST")
                        .endPoint(ApiPath.AuthPath.API_AUTH + ApiPath.AuthPath.API_AUTH_AUTHENTICATE)
                        .method(EndPointMethod.POST)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_AUTH_REGISTER_POST")
                        .endPoint(ApiPath.AuthPath.API_AUTH + ApiPath.AuthPath.API_AUTH_REGISTER)
                        .method(EndPointMethod.POST)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_AUTH_REGISTER_VALIDATION_PATCH")
                        .endPoint(ApiPath.AuthPath.API_AUTH + ApiPath.AuthPath.API_AUTH_REGISTER_VALIDATION)
                        .method(EndPointMethod.PATCH)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_HOME_GET")
                        .endPoint(ApiPath.HomePath.API_HOME + ApiPath.HomePath.API_HOME)
                        .method(EndPointMethod.GET)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_HOME_1_GET")
                        .endPoint(ApiPath.HomePath.API_HOME + ApiPath.HomePath.API_PAGE_1)
                        .method(EndPointMethod.GET)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_HOME_2_GET")
                        .endPoint(ApiPath.HomePath.API_HOME + ApiPath.HomePath.API_PAGE_2)
                        .method(EndPointMethod.GET)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_HOME_3_GET")
                        .endPoint(ApiPath.HomePath.API_HOME + ApiPath.HomePath.API_PAGE_3)
                        .method(EndPointMethod.GET)
                        .build());
        permissionHasEndPointEntities.add(
                EndPointEntity.builder()
                        .name("API_HOME_4_GET")
                        .endPoint(ApiPath.HomePath.API_HOME + ApiPath.HomePath.API_PAGE_4)
                        .method(EndPointMethod.GET)
                        .build());

        return permissionHasEndPointEntities;
    }
}
