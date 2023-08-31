package com.cyber009.spring3.t0.common.mapper;

import com.cyber009.spring3.t0.common.dto.AddressDto;
import com.cyber009.spring3.t0.common.entity.Address;
import com.cyber009.spring3.t0.common.param.AddressParam;
import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.WorkFlowDto;
import com.cyber009.spring3.t0.entity.WorkFlow;
import com.cyber009.spring3.t0.param.WorkFlowParam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = CommonMapperConfig.class)
public interface AddressMapper {

    void paramToEntity(AddressParam param, @MappingTarget Address entity);

    AddressDto entityToDto(Address entity);
}
