package com.cyber009.spring3.t0.service;

import com.cyber009.spring3.t0.common.entity.Address;
import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.entity.InstanceWisePermission;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.event.instance.InstanceCreateEvent;
import com.cyber009.spring3.t0.mapper.InstanceWisePermissionMapper;
import com.cyber009.spring3.t0.mapper.OfficeMapper;
import com.cyber009.spring3.t0.param.office.OfficeParam;
import com.cyber009.spring3.t0.param.office.SearchOfficeParam;
import com.cyber009.spring3.t0.repository.OfficeRepository;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstanceWisePermissionService {

    private final InstanceWisePermissionRepository instanceWisePermissionRepository;
    private final InstanceWisePermissionMapper instanceWisePermissionMapper;


    public InstanceWisePermissionDto save(InstanceCreateEvent event) {
        InstanceWisePermission entity = InstanceWisePermission.builder().build();

        Optional<InstanceWisePermission> opEntity = instanceWisePermissionRepository.findTopByInstanceFromAndInstanceIdOrderByCreateAt(event.getEntityName(), event.getInstanceId());
        if(opEntity.isPresent()) entity = opEntity.get();
        paramToEntity(event, entity);
        entity.setId(UUID.randomUUID());
        entity = instanceWisePermissionRepository.save(entity);

        InstanceWisePermissionDto dto = entityToDto(entity);
        return dto;
    }

    private void paramToEntity(InstanceCreateEvent event, InstanceWisePermission entity) {
        if(entity.getInstanceFrom() != null) entity.setInstanceFrom(event.getEntityName());
        if(entity.getInstanceId() != null) entity.setInstanceId(event.getInstanceId());
        if(entity.getAccessPolicy() != null) entity.setAccessPolicy("PUBLIC");
    }

    private InstanceWisePermissionDto entityToDto(InstanceWisePermission entity) {
        return instanceWisePermissionMapper.entityToDto(entity);
    }

    private InstanceWisePermissionDto entityToSimpleDto(InstanceWisePermission entity) {
        return instanceWisePermissionMapper.entityToSimpleDto(entity);
    }
}
