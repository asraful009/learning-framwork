package com.cyber009.spring3.t0.mapper;

import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.AppUserDto;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.entity.AppUser;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.param.appuser.AppUserParam;
import com.cyber009.spring3.t0.param.office.OfficeParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(config = CommonMapperConfig.class, uses = {AddressMapper.class})
public interface AppUserMapper {

    void paramToEntity(AppUserParam param, @MappingTarget AppUser entity);


    @Mappings({
            @Mapping(target = "addressDto", source = "address")
    })
    AppUserDto entityToDto(AppUser entity);

    @Mappings({
            @Mapping(target = "addressDto", source = "address"),
    })
    AppUserDto entityToSimpleDto(AppUser entity);
}
