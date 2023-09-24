package com.cyber009.spring3.t0.service.office;

import com.cyber009.spring3.t0.common.entity.Address;
import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.dto.office.office.OfficeDto;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWiseAppointmentHasPermission;
import com.cyber009.spring3.t0.entity.office.Office;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWiseAppUserHasPermission;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermission;
import com.cyber009.spring3.t0.mapper.office.OfficeMapper;
import com.cyber009.spring3.t0.param.office.office.OfficeParam;
import com.cyber009.spring3.t0.param.office.office.SearchOfficeParam;
import com.cyber009.spring3.t0.repository.office.OfficeRepository;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRedisRepository;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final InstanceWisePermissionRepository instanceWisePermissionRepository;
    private final InstanceWisePermissionRedisRepository instanceWisePermissionRedisRepository;
    private final OfficeMapper officeMapper;
    private final AddressMapper addressMapper;

    public List<OfficeDto> findAll(SearchOfficeParam param) {
        List<Office> entities = officeRepository.findAll();
        return entities.stream().map(this::entityToSimpleDto).map(dto-> filterWithPermission(param.getAppUserId(), param.getAppointmentId(), "READ", dto)).filter(Objects::nonNull).collect(Collectors.toList());
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
        return dto;
    }

    private OfficeDto filterWithPermission(UUID appUserId, UUID appointmentId, String accessMode, OfficeDto dto) {
        Optional<InstanceWisePermission> opPermission = instanceWisePermissionRepository.findTopByInstanceFromAndInstanceIdOrderByCreateAt(Office.class.getName(), dto.getId());
        log.info("permission :{}", opPermission);
        if(opPermission.isEmpty()) return null;
        InstanceWisePermission permission = opPermission.get();
        if(permission.getAccessPolicy().equals("PUBLIC")) {
            return dto;
        }
        if(permission.getAccessPolicy().equals("AUTH_ONLY")) {
            if(appUserId == null) return null;
            return dto;
        }
        if(permission.getAccessPolicy().equals("ACCESS_ONLY")) {
            Optional<InstanceWiseAppUserHasPermission> appUserHasPermission =
                    permission.getInstanceWiseAppUserHasPermissions().stream().filter(o -> o.getAppUserId().equals(appUserId) && (o.getMethod().equals("READ") || o.getMethod().equals("WRITE"))).findFirst();
            if(appUserHasPermission.isEmpty()) return null;
            return dto;
        }
        if(permission.getAccessPolicy().equals("APPOINTMENT_ONLY")) {
            Optional<InstanceWiseAppointmentHasPermission> appointmentHasPermission =
                    permission.getInstanceWiseAppointmentHasPermissions().stream().filter(o -> o.getAppointment().equals(appointmentId) && (o.getMethod().equals("READ") || o.getMethod().equals("WRITE"))).findFirst();
            if(appointmentHasPermission.isEmpty()) return null;
            return dto;
        }
        if(permission.getAccessPolicy().equals("APP_USER_AND_APPOINTMENT_ONLY")) {
            if (appUserId != null) {
                Optional<InstanceWiseAppUserHasPermission> appUserHasPermission =
                        permission.getInstanceWiseAppUserHasPermissions().stream().filter(o -> o.getAppUserId().equals(appUserId) && (o.getMethod().equals("READ") || o.getMethod().equals("WRITE"))).findFirst();
                if(appUserHasPermission.isPresent()) return dto;
            }
            if (appointmentId != null) {
                Optional<InstanceWiseAppointmentHasPermission> appointmentHasPermission =
                        permission.getInstanceWiseAppointmentHasPermissions().stream().filter(o -> o.getAppointment().equals(appointmentId) && (o.getMethod().equals("READ") || o.getMethod().equals("WRITE"))).findFirst();
                if (appointmentHasPermission.isPresent()) return dto;
            }
            return null;
        }
        return null;
    }
}
