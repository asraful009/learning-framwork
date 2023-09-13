package com.cyber009.spring3.t0.mapper;

import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.entity.InstanceWisePermission;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class, uses = {})
public interface InstanceWisePermissionMapper {
    InstanceWisePermissionDto entityToDto(InstanceWisePermission entity);
    InstanceWisePermissionDto entityToSimpleDto(InstanceWisePermission entity);
}
