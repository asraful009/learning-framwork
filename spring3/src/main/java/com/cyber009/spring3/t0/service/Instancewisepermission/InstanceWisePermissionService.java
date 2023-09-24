package com.cyber009.spring3.t0.service.Instancewisepermission;

import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWiseAppUserHasPermission;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWiseAppointmentHasPermission;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermission;
import com.cyber009.spring3.t0.common.instance.InstanceCreateEvent;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermissionRedis;
import com.cyber009.spring3.t0.mapper.InstanceWisePermissionMapper;
import com.cyber009.spring3.t0.param.instance.InstanceWiseAppUserHasPermissionParam;
import com.cyber009.spring3.t0.param.instance.InstanceWiseAppointmentHasPermissionParam;
import com.cyber009.spring3.t0.param.instance.InstanceWisePermissionParam;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRedisRepository;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
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
    private final InstanceWisePermissionRedisRepository instanceWisePermissionRedisRepository;
    private final InstanceWisePermissionMapper instanceWisePermissionMapper;


    @Async
    public InstanceWisePermissionDto save(InstanceCreateEvent event) {
        InstanceWisePermission entity = InstanceWisePermission.builder().build();

        Optional<InstanceWisePermission> opEntity = instanceWisePermissionRepository.findTopByInstanceFromAndInstanceIdOrderByCreateAt(event.getEntityName(), event.getInstanceId());
        if(opEntity.isPresent()) entity = opEntity.get();
        eventToEntity(event, entity);
        entity.setId(UUID.randomUUID());
        entity = instanceWisePermissionRepository.save(entity);
        InstanceWisePermissionDto dto = entityToDto(entity);
        InstanceWisePermissionRedis cashe = InstanceWisePermissionRedis.builder()
                .id(dto.getId())
                .instanceWisePermissionDto(dto)
                .build();
        instanceWisePermissionRedisRepository.save(cashe);
        return dto;
    }

    public InstanceWisePermissionDto update(UUID id, InstanceWisePermissionParam param) {
        Optional<InstanceWisePermission> opEntity = instanceWisePermissionRepository.findById(id);
        if(opEntity.isEmpty()) return null;
        InstanceWisePermission entity = opEntity.get();
        paramToEntity(param, entity);
        entity = instanceWisePermissionRepository.save(entity);
        return entityToDto(entity);
    }

    public void generateCache() {
        List<InstanceWisePermission> entities = instanceWisePermissionRepository.findAll();
        for (InstanceWisePermission entity: entities) {
            InstanceWisePermissionDto dto = entityToDto(entity);
            InstanceWisePermissionRedis cashe = InstanceWisePermissionRedis.builder()
                    .id(dto.getInstanceId())
                    .instanceWisePermissionDto(dto)
                    .build();
            instanceWisePermissionRedisRepository.save(cashe);
        }
    }

    private void eventToEntity(InstanceCreateEvent event, InstanceWisePermission entity) {
        if(entity.getInstanceFrom() == null) entity.setInstanceFrom(event.getEntityName());
        if(entity.getInstanceId() == null) entity.setInstanceId(event.getInstanceId());
        if(entity.getAccessPolicy() == null) entity.setAccessPolicy("PUBLIC");
    }

    private void paramToEntity(InstanceWisePermissionParam param, InstanceWisePermission entity) {
        entity.setAccessPolicy(param.getAccessPolicy());
        prepareInstanceWiseAppUserHasPermission(param, entity);
        prepareInstanceWiseAppointmentHasPermission(param, entity);
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
            instanceWiseAppUserHasPermission.setIsDelete(true);
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


    private void prepareInstanceWiseAppointmentHasPermission(InstanceWisePermissionParam param, InstanceWisePermission entity) {
        List<InstanceWiseAppointmentHasPermissionParam> appointmentHasPermissionParams = param.getInstanceWiseAppointmentHasPermissionParams();
        if(appointmentHasPermissionParams == null || appointmentHasPermissionParams.isEmpty()) return;
        List<InstanceWiseAppointmentHasPermission> instanceWiseAppointmentHasPermissions = entity.getInstanceWiseAppointmentHasPermissions();
        if(instanceWiseAppointmentHasPermissions == null) {
            instanceWiseAppointmentHasPermissions = new LinkedList<>();
            entity.setInstanceWiseAppointmentHasPermissions(instanceWiseAppointmentHasPermissions);
        }
        for (InstanceWiseAppointmentHasPermission instanceWiseAppUserHasPermission : instanceWiseAppointmentHasPermissions) {
            instanceWiseAppUserHasPermission.setIsDelete(true);
        }
        AtomicInteger sortingIndex = new AtomicInteger(0);
        for (InstanceWiseAppointmentHasPermissionParam appointmentHasPermissionParam : appointmentHasPermissionParams) {
            InstanceWiseAppointmentHasPermission appointmentHasPermission = InstanceWiseAppointmentHasPermission.builder()
                    .id(UUID.randomUUID())
                    .appointment(appointmentHasPermissionParam.getAppointmentId())
                    .method(appointmentHasPermissionParam.getMethod())
                    .sortingOrder(sortingIndex.getAndIncrement())
                    .instanceWisePermission(entity)
                    .build();
            instanceWiseAppointmentHasPermissions.add(appointmentHasPermission);
        }
    }

    private InstanceWisePermissionDto entityToDto(InstanceWisePermission entity) {
        return instanceWisePermissionMapper.entityToDto(entity);
    }

    private InstanceWisePermissionDto entityToSimpleDto(InstanceWisePermission entity) {
        return instanceWisePermissionMapper.entityToSimpleDto(entity);
    }
}
