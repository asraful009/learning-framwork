package com.cyber009.spring3.t0.controller;

import com.cyber009.spring3.t0.dto.AppUserDto;
import com.cyber009.spring3.t0.param.appuser.AppUserParam;
import com.cyber009.spring3.t0.param.appuser.SearchAppUserParam;
import com.cyber009.spring3.t0.service.appuser.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app-user")
@RequiredArgsConstructor
@Slf4j
public class AppUserController {
    private final AppUserService appUserService;


    @GetMapping
    public Page<AppUserDto> findAll(@ModelAttribute SearchAppUserParam param) {
        log.info("param:", param);
        return null;
    }

    @PostMapping
    public AppUserDto save(@RequestBody AppUserParam param) {
        return appUserService.save(param);
    }
}
