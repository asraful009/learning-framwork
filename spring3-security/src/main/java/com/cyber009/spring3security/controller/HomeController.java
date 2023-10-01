package com.cyber009.spring3security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Home Controller</h1>
 * <p>Home Controller is entry point for web</p>
 * @author pavel
 * @since 0.0.1
 * @version 0.0.1
 */
@RestController
@RequestMapping("")
public class HomeController {

    @GetMapping("")
    public String index() {
        return "Hi all";
    }
}
