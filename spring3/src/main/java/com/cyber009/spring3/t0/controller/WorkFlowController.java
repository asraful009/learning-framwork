package com.cyber009.spring3.t0.controller;


import com.cyber009.spring3.t0.service.workflow.WorkFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workflow")
@RequiredArgsConstructor
public class WorkFlowController {

    private final WorkFlowService workFlowService;


}
