package com.cyber009.spring3.t0.mapper;

import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.entity.Office;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface OfficeMapper {

    OfficeDto entityToDto(Office entity);
}
