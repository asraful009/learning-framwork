package com.cyber009.spring3security.controller.auth;


import com.cyber009.spring3security.dto.response.auth.AuthenticationResponse;
import com.cyber009.spring3security.param.auth.RegisterParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Authentication Controller
 * @author asraful
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(RegisterParam param) {

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(RegisterParam param) {

    }
}
