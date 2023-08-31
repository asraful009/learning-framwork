package com.cyber009.spring3.t0.mapper;

import com.cyber009.spring3.t0.config.CommonMapperConfig;
import com.cyber009.spring3.t0.dto.WorkFlowDto;
import com.cyber009.spring3.t0.entity.WorkFlow;
import com.cyber009.spring3.t0.param.WorkFlowParam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = CommonMapperConfig.class)
public interface WorkFlowMapper {

    void paramToEntity(WorkFlowParam param, @MappingTarget WorkFlow entity);

    WorkFlowDto entityToDto(WorkFlow entity);
}
