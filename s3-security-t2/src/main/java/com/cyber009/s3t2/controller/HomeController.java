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

    @GetMapping(value = ApiPath.HomePath.API_PAGE_1)
    public ResponseEntity<String> home1() {
        return ResponseEntity.ok("Welcome Page 1 to the S3T2 application!");
    }

    @GetMapping(value = ApiPath.HomePath.API_PAGE_2)
    public ResponseEntity<String> home2() {
        return ResponseEntity.ok("Welcome Page 2 to the S3T2 application!");
    }

    @GetMapping(value = ApiPath.HomePath.API_PAGE_3)
    public ResponseEntity<String> home3() {
        return ResponseEntity.ok("Welcome Page 3 to the S3T2 application!");
    }

    @GetMapping(value = ApiPath.HomePath.API_PAGE_4)
    public ResponseEntity<String> home4() {
        return ResponseEntity.ok("Welcome Page 4 to the S3T2 application!");
    }

}
