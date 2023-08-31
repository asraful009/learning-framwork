package com.cyber009.spring3.t0.mapper;

import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.param.OfficeParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(config = CommonMapperConfig.class, uses = {AddressMapper.class})
public interface OfficeMapper {

    void paramToEntity(OfficeParam param, @MappingTarget Office entity);


    @Mappings({
            @Mapping(target = "addressDto", source = "address")
    })
    OfficeDto entityToDto(Office entity);
}
