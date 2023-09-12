package com.cyber009.spring3.t0.mapper;

import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.entity.InstanceWisePermission;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.event.instance.InstanceCreateEvent;
import com.cyber009.spring3.t0.param.office.OfficeParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(config = CommonMapperConfig.class, uses = {})
public interface InstanceWisePermissionMapper {
    InstanceWisePermissionDto entityToDto(InstanceWisePermission entity);
    InstanceWisePermissionDto entityToSimpleDto(InstanceWisePermission entity);
}
