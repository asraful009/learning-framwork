package com.cyber009.spring3.t0.service;

import com.cyber009.spring3.t0.common.entity.Address;
import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermission;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermissionRedis;
import com.cyber009.spring3.t0.mapper.OfficeMapper;
import com.cyber009.spring3.t0.param.office.OfficeParam;
import com.cyber009.spring3.t0.param.office.SearchOfficeParam;
import com.cyber009.spring3.t0.repository.OfficeRepository;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRedisRepository;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final InstanceWisePermissionRedisRepository instanceWisePermissionRedisRepository;
    private final OfficeMapper officeMapper;
    private final AddressMapper addressMapper;

    public Page<OfficeDto> findAll(SearchOfficeParam param) {
        Page<Office> entities = officeRepository.findAll(param.getPageable());
        return entities.map(this::entityToSimpleDto).map(this::filterWithPermission);
    }

    public OfficeDto save(OfficeParam param) {
        Office entity = Office.builder().build();


        Optional<Office> opEntity = officeRepository.findTopByNameOrderByCreateAt(param.getName());
        if(opEntity.isPresent()) entity = opEntity.get();
        paramToEntity(param, entity);
        if(entity.getId() == null) entity.setId(UUID.randomUUID());
        entity = officeRepository.save(entity);
        OfficeDto dto = entityToDto(entity);
        return dto;
    }

    private void paramToEntity(OfficeParam param, Office entity) {
        officeMapper.paramToEntity(param, entity);
        Address officeAddress = entity.getAddress();
        if(officeAddress == null) {
            officeAddress = Address.builder().id(UUID.randomUUID()).build();
            entity.setAddress(officeAddress);
        }
        addressMapper.paramToEntity(param.getAddressParam(), officeAddress);
    }

    private OfficeDto entityToDto(Office entity) {
        OfficeDto dto = officeMapper.entityToDto(entity);
        return dto;
    }

    private OfficeDto entityToSimpleDto(Office entity) {
        OfficeDto dto = officeMapper.entityToSimpleDto(entity);
        log.info("sss dto: {}", dto);
        return dto;
    }

    private OfficeDto filterWithPermission(OfficeDto dto) {
        log.info("sss dto: {}", dto);
        Optional<InstanceWisePermissionRedis> cache = instanceWisePermissionRedisRepository.findById(dto.getId());

      //  if(cache.isEmpty()) return null;
        return dto;
    }
}
