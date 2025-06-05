package com.cyber009.s3t2.service;

import com.cyber009.s3t2.constance.ApiPath;
import com.cyber009.s3t2.entity.EndPointEntity;
import com.cyber009.s3t2.enums.EndPointMethod;
import com.cyber009.s3t2.repository.EndPointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final EndPointRepository endPointRepository;

    public EndPointEntity savePermissionHasEndPoint(EndPointEntity permissionHasEndPointEntity) {
        log.info("Saving PermissionHasEndPoint: {}", permissionHasEndPointEntity);
        return endPointRepository.save(permissionHasEndPointEntity);
    }


}
