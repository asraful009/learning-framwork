package com.cyber009.spring3.t0.controller.office;

import com.cyber009.spring3.t0.dto.office.appointment.AppointmentDto;
import com.cyber009.spring3.t0.dto.office.office.OfficeDto;
import com.cyber009.spring3.t0.param.office.appointment.AppointmentParam;
import com.cyber009.spring3.t0.param.office.appointment.SearchAppointmentParam;
import com.cyber009.spring3.t0.param.office.office.OfficeParam;
import com.cyber009.spring3.t0.param.office.office.SearchOfficeParam;
import com.cyber009.spring3.t0.service.office.AppointmentService;
import com.cyber009.spring3.t0.service.office.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
@Slf4j
public class AppointmentController {
    private final OfficeService officeService;
    private final AppointmentService appointmentService;


    @GetMapping
    public List<AppointmentDto> findAll(@ModelAttribute SearchAppointmentParam param) {
        log.info("param:", param);
        List<AppointmentDto> page = appointmentService.findAll(param);
        return page;
    }

    @PostMapping
    public AppointmentDto save(@RequestBody AppointmentParam param) {
        return appointmentService.save(param);
    }
}
