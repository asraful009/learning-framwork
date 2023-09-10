package com.cyber009.spring3.t0.service;

import com.cyber009.spring3.t0.common.entity.Address;
import com.cyber009.spring3.t0.common.mapper.AddressMapper;
import com.cyber009.spring3.t0.dto.AppUserDto;
import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.entity.AppUser;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.mapper.AppUserMapper;
import com.cyber009.spring3.t0.mapper.OfficeMapper;
import com.cyber009.spring3.t0.param.appuser.AppUserParam;
import com.cyber009.spring3.t0.param.office.OfficeParam;
import com.cyber009.spring3.t0.param.office.SearchOfficeParam;
import com.cyber009.spring3.t0.repository.AppUserRepository;
import com.cyber009.spring3.t0.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private final AddressMapper addressMapper;

    public Page<AppUserDto> findAll(SearchOfficeParam param) {
        Page<AppUser> entities = appUserRepository.findAll(param.getPageable());
        return entities.map(this::entityToSimpleDto);
    }

    public AppUserDto save(AppUserParam param) {
        AppUser entity = AppUser.builder().build();

        Optional<AppUser> opEntity = appUserRepository.findTopByNameOrderByCreateAt(param.getName());
        if(opEntity.isPresent()) entity = opEntity.get();
        paramToEntity(param, entity);
        entity.setId(UUID.randomUUID());
        entity = appUserRepository.save(entity);
        AppUserDto dto = entityToDto(entity);
        return dto;
    }

    private void paramToEntity(AppUserParam param, AppUser entity) {
        appUserMapper.paramToEntity(param, entity);
        Address officeAddress = entity.getAddress();
        if(officeAddress == null) {
            officeAddress = Address.builder().id(UUID.randomUUID()).build();
            entity.setAddress(officeAddress);
        }
        addressMapper.paramToEntity(param.getAddressParam(), officeAddress);
    }

    private AppUserDto entityToDto(AppUser entity) {
        AppUserDto dto = appUserMapper.entityToDto(entity);
        return dto;
    }

    private AppUserDto entityToSimpleDto(AppUser entity) {
        AppUserDto dto = appUserMapper.entityToSimpleDto(entity);
        return dto;
    }
}
