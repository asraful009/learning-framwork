package com.cyber009.s3t2.controller;

import com.cyber009.s3t2.constance.ApiPath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiPath.HomePath.API_HOME)
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    @GetMapping()
    public ResponseEntity<String> home() {
        log.info("Home endpoint accessed");
        return ResponseEntity.ok("Welcome to the S3T2 application!");
    }

}
