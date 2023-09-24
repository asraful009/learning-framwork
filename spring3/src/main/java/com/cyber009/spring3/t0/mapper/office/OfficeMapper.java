package com.cyber009.spring3.t0.mapper.office;

import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.office.office.OfficeDto;
import com.cyber009.spring3.t0.entity.office.Office;
import com.cyber009.spring3.t0.param.office.office.OfficeParam;
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

    @Mappings({
            @Mapping(target = "addressDto", ignore = true),
            @Mapping(target = "parentOfficeDto", ignore = true),
            @Mapping(target = "childOfficeDtos", ignore = true),
    })
    OfficeDto entityToSimpleDto(Office entity);
}
