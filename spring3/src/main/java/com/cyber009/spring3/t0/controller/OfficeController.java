package com.cyber009.spring3.t0.controller;

import com.cyber009.spring3.t0.dto.OfficeDto;
import com.cyber009.spring3.t0.param.OfficeParam;
import com.cyber009.spring3.t0.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/office")
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }
    @PostMapping
    public OfficeDto save(@RequestBody OfficeParam param) {
        return officeService.save(param);
    }
}
