package com.cyber009.spring3.t0.mapper.office;

import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.office.appointment.AppointmentDto;
import com.cyber009.spring3.t0.entity.office.Appointment;
import com.cyber009.spring3.t0.param.office.appointment.AppointmentParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(config = CommonMapperConfig.class, uses = {AddressMapper.class})
public interface AppointmentMapper {

    void paramToEntity(AppointmentParam param, @MappingTarget Appointment entity);


    @Mappings({
            @Mapping(target = "officeDto", source = "office")
    })
    AppointmentDto entityToDto(Appointment entity);

    @Mappings({
            @Mapping(target = "officeDto", ignore = true)
    })
    AppointmentDto entityToSimpleDto(Appointment entity);
}
