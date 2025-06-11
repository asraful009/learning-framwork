package com.cyber009.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyber009.common.utility.DataTime;

@RestController
@RequestMapping
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Welcome to the Cyber009 Office Application! " + DataTime.nowUtc();
    }
}
