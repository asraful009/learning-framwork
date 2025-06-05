package com.cyber009.s3t2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    @GetMapping(value = "")
    public ResponseEntity<String> home() {
        log.info("Home endpoint accessed");
        return ResponseEntity.ok("Welcome to the S3T2 application!");
    }

}
