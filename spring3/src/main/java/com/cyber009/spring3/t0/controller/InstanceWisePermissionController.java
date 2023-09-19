package com.cyber009.spring3.t0.controller;

import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.param.instance.InstanceWisePermissionParam;
import com.cyber009.spring3.t0.param.office.OfficeParam;
import com.cyber009.spring3.t0.param.office.SearchOfficeParam;
import com.cyber009.spring3.t0.service.InstanceWisePermissionService;
import com.cyber009.spring3.t0.service.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/instance-wise-permission")
@RequiredArgsConstructor
@Slf4j
public class InstanceWisePermissionController {
    private final InstanceWisePermissionService instanceWisePermissionService;

    @PatchMapping(value = "/generate-cache")
    public HttpStatus generateCache() {
        instanceWisePermissionService.generateCache();
        return HttpStatus.OK;
    }

    @PatchMapping(value = "/{id}")
    public InstanceWisePermissionDto update(@PathVariable UUID id, @RequestBody InstanceWisePermissionParam param) {
        return instanceWisePermissionService.update(id, param);
    }


}
