package com.cyber009.spring3security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Auth Controller</h1>
 * <p>Auth Controller is entry point for web</p>
 * @author pavel
 * @since 0.0.1
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("")
    public String index() {
        return "Hi all";
    }
}
