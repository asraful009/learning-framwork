package com.cyber009.spring3.t0.service;

import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.dto.WorkFlowDto;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.entity.WorkFlow;
import com.cyber009.spring3.t0.mapper.OfficeMapper;
import com.cyber009.spring3.t0.mapper.WorkFlowMapper;
import com.cyber009.spring3.t0.param.OfficeParam;
import com.cyber009.spring3.t0.param.WorkFlowParam;
import com.cyber009.spring3.t0.repository.OfficeRepository;
import com.cyber009.spring3.t0.repository.WorkFlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkFlowService {

    private final WorkFlowRepository workFlowRepository;
    private final WorkFlowMapper workFlowMapper;

    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;



    public WorkFlowDto save(WorkFlowParam param) {
        WorkFlow entity = WorkFlow.builder().build();

        Optional<WorkFlow> opEntity = workFlowRepository.findTopByTitleOrderByCreateAt(param.getTitle());
        if(opEntity.isPresent()) entity = opEntity.get();
        paramToEntity(param, entity);
        entity.setId(UUID.randomUUID());
        entity = workFlowRepository.save(entity);
        OfficeDto dto = entityToDto(entity);
        return dto;
    }

    private void paramToEntity(WorkFlowParam param, WorkFlow entity) {
        workFlowMapper.paramToEntity(param, entity);

    }

    private WorkFlowDto entityToDto(WorkFlow entity) {
        WorkFlowDto dto = workFlowMapper.entityToDto(entity);
        return dto;
    }
}
