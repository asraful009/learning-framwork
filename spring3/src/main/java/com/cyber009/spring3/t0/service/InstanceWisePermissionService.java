package com.cyber009.spring3.t0.service;

import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.entity.InstanceWiseAppUserHasPermission;
import com.cyber009.spring3.t0.entity.InstanceWisePermission;
import com.cyber009.spring3.t0.event.instance.InstanceCreateEvent;
import com.cyber009.spring3.t0.mapper.InstanceWisePermissionMapper;
import com.cyber009.spring3.t0.param.instance.InstanceWiseAppUserHasPermissionParam;
import com.cyber009.spring3.t0.param.instance.InstanceWisePermissionParam;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class InstanceWisePermissionService {

    private final InstanceWisePermissionRepository instanceWisePermissionRepository;
    private final InstanceWisePermissionMapper instanceWisePermissionMapper;


    public InstanceWisePermissionDto save(InstanceCreateEvent event) {
        InstanceWisePermission entity = InstanceWisePermission.builder().build();

        Optional<InstanceWisePermission> opEntity = instanceWisePermissionRepository.findTopByInstanceFromAndInstanceIdOrderByCreateAt(event.getEntityName(), event.getInstanceId());
        if(opEntity.isPresent()) entity = opEntity.get();
        eventToEntity(event, entity);
        entity.setId(UUID.randomUUID());
        entity = instanceWisePermissionRepository.save(entity);
        return entityToDto(entity);
    }

    public InstanceWisePermissionDto update(UUID id, InstanceWisePermissionParam param) {
        Optional<InstanceWisePermission> opEntity = instanceWisePermissionRepository.findById(id);
        if(opEntity.isEmpty()) return null;
        InstanceWisePermission entity = opEntity.get();
        paramToEntity(param, entity);
        entity = instanceWisePermissionRepository.save(entity);
        return entityToDto(entity);
    }

    private void eventToEntity(InstanceCreateEvent event, InstanceWisePermission entity) {
        if(entity.getInstanceFrom() == null) entity.setInstanceFrom(event.getEntityName());
        if(entity.getInstanceId() == null) entity.setInstanceId(event.getInstanceId());
        if(entity.getAccessPolicy() == null) entity.setAccessPolicy("PUBLIC");
    }

    private void paramToEntity(InstanceWisePermissionParam param, InstanceWisePermission entity) {
        entity.setAccessPolicy(param.getAccessPolicy());
        prepareInstanceWiseAppUserHasPermission(param, entity);
    }

    private void prepareInstanceWiseAppUserHasPermission(InstanceWisePermissionParam param, InstanceWisePermission entity) {
        List<InstanceWiseAppUserHasPermissionParam> appUserHasPermissionParamList = param.getInstanceWiseAppUserHasPermissionParams();
        if(appUserHasPermissionParamList == null || appUserHasPermissionParamList.isEmpty()) return;
        List<InstanceWiseAppUserHasPermission> instanceWiseAppUserHasPermissions = entity.getInstanceWiseAppUserHasPermissions();
        if(instanceWiseAppUserHasPermissions == null) {
            instanceWiseAppUserHasPermissions = new LinkedList<>();
            entity.setInstanceWiseAppUserHasPermissions(instanceWiseAppUserHasPermissions);
        }
        for (InstanceWiseAppUserHasPermission instanceWiseAppUserHasPermission : instanceWiseAppUserHasPermissions) {
//            instanceWiseAppUserHasPermission.set
        }
        AtomicInteger sortingIndex = new AtomicInteger(0);
        for (InstanceWiseAppUserHasPermissionParam appUserHasPermissionParam : appUserHasPermissionParamList) {
            InstanceWiseAppUserHasPermission appUserHasPermission = InstanceWiseAppUserHasPermission.builder()
                    .id(UUID.randomUUID())
                    .appUserId(appUserHasPermissionParam.getAppUserId())
                    .method(appUserHasPermissionParam.getMethod())
                    .sortingOrder(sortingIndex.getAndIncrement())
                    .instanceWisePermission(entity)
                    .build();
            instanceWiseAppUserHasPermissions.add(appUserHasPermission);
        }
    }

    private InstanceWisePermissionDto entityToDto(InstanceWisePermission entity) {
        return instanceWisePermissionMapper.entityToDto(entity);
    }

    private InstanceWisePermissionDto entityToSimpleDto(InstanceWisePermission entity) {
        return instanceWisePermissionMapper.entityToSimpleDto(entity);
    }
}
