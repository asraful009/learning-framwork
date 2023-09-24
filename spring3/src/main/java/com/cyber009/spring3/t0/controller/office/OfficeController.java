package com.cyber009.spring3.t0.controller.office;

import com.cyber009.spring3.t0.dto.office.office.OfficeDto;
import com.cyber009.spring3.t0.param.office.office.OfficeParam;
import com.cyber009.spring3.t0.param.office.office.SearchOfficeParam;
import com.cyber009.spring3.t0.service.office.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
@RequiredArgsConstructor
@Slf4j
public class OfficeController {
    private final OfficeService officeService;


    @GetMapping
    public List<OfficeDto> findAll(@ModelAttribute SearchOfficeParam param) {
        log.info("param:", param);
        List<OfficeDto> page = officeService.findAll(param);
        return page;
    }

    @PostMapping
    public OfficeDto save(@RequestBody OfficeParam param) {
        return officeService.save(param);
    }
}
