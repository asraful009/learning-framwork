package com.cyber009.spring3.t0.service;

import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.mapper.OfficeMapper;
import com.cyber009.spring3.t0.param.OfficeParam;
import com.cyber009.spring3.t0.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    public OfficeDto save(OfficeParam param) {
        Office entity = Office.builder().build();

        Optional<Office> opEntity = officeRepository.findTopByNameOrderByCreateAt(param.getName());
        if(opEntity.isPresent()) entity = opEntity.get();
        paramToEntity(param, entity);
        entity = officeRepository.save(entity);
        OfficeDto dto = entityToDto(entity);
        return dto;
    }

    private void paramToEntity(OfficeParam param, Office entity) {
        officeMapper.paramToEntity(param, entity);
        entity.setId(UUID.randomUUID());
    }

    private OfficeDto entityToDto(Office entity) {
        OfficeDto dto = officeMapper.entityToDto(entity);
        return dto;
    }
}
