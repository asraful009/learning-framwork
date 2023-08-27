package com.cyber009.spring3.t0.mapper;

import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.param.OfficeParam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = CommonMapperConfig.class)
public interface OfficeMapper {

    void paramToEntity(OfficeParam param, @MappingTarget Office entity);

    OfficeDto entityToDto(Office entity);
}
