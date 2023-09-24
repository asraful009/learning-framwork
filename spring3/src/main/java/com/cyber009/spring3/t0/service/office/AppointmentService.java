package com.cyber009.spring3.t0.service.office;

import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.dto.office.appointment.AppointmentDto;
import com.cyber009.spring3.t0.dto.office.office.OfficeDto;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWiseAppUserHasPermission;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermission;
import com.cyber009.spring3.t0.entity.office.Appointment;
import com.cyber009.spring3.t0.entity.office.Office;
import com.cyber009.spring3.t0.mapper.office.AppointmentMapper;
import com.cyber009.spring3.t0.mapper.office.OfficeMapper;
import com.cyber009.spring3.t0.param.office.appointment.AppointmentParam;
import com.cyber009.spring3.t0.param.office.appointment.SearchAppointmentParam;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRedisRepository;
import com.cyber009.spring3.t0.repository.instance.InstanceWisePermissionRepository;
import com.cyber009.spring3.t0.repository.office.AppointmentRepository;
import com.cyber009.spring3.t0.repository.office.OfficeRepository;
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
public class AppointmentService {

    private final OfficeRepository officeRepository;
    private final AppointmentRepository appointmentRepository;
    private final InstanceWisePermissionRepository instanceWisePermissionRepository;
    private final InstanceWisePermissionRedisRepository instanceWisePermissionRedisRepository;
    private final OfficeMapper officeMapper;
    private final AppointmentMapper appointmentMapper;
    private final AddressMapper addressMapper;

    public List<AppointmentDto> findAll(SearchAppointmentParam param) {
        List<Appointment> entities = appointmentRepository.findAll();
        return entities.stream().map(this::entityToSimpleDto)       .collect(Collectors.toList());
    }

    public AppointmentDto save(AppointmentParam param) {
        Appointment entity = Appointment.builder().build();
        Optional<Appointment> opEntity = appointmentRepository.findTopByNameOrderByCreateAt(param.getName());
        if(opEntity.isPresent()) entity = opEntity.get();
        paramToEntity(param, entity);
        if(entity.getId() == null) entity.setId(UUID.randomUUID());
        entity = appointmentRepository.save(entity);
        AppointmentDto dto = entityToDto(entity);
        return dto;
    }

    private void paramToEntity(AppointmentParam param, Appointment entity) {
        appointmentMapper.paramToEntity(param, entity);
        if(param.getOfficeId() != null) {
            Optional<Office> optionalOffice = officeRepository.findById(param.getOfficeId());
            if(optionalOffice.isPresent()) entity.setOffice(optionalOffice.get());
        }
    }

    private AppointmentDto entityToDto(Appointment entity) {
        AppointmentDto dto = appointmentMapper.entityToDto(entity);
        return dto;
    }

    private AppointmentDto entityToSimpleDto(Appointment entity) {
        AppointmentDto dto = appointmentMapper.entityToSimpleDto(entity);
        return dto;
    }

}
