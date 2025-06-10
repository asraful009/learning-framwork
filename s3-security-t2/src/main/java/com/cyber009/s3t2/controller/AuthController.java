package com.cyber009.s3t2.controller;

import com.cyber009.s3t2.constance.ApiPath;
import com.cyber009.s3t2.dto.AuthenticationDto;
import com.cyber009.s3t2.entity.UserEntity;
import com.cyber009.s3t2.param.AuthenticationParam;
import com.cyber009.s3t2.param.RegisterParam;
import com.cyber009.s3t2.param.RegisterValidationParam;
import com.cyber009.s3t2.repository.UserRepository;
import com.cyber009.s3t2.service.JwtService;
import com.cyber009.s3t2.service.PasswordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = ApiPath.AuthPath.API_AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping(value = ApiPath.AuthPath.API_AUTH_REGISTER)
    public AuthenticationDto register(@RequestBody RegisterParam request) throws JsonProcessingException {
        var user = UserEntity.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordService.encodeWithPepper(request.getEmail(), request.getPassword()))
                .role("USER")
                .build();
        userRepository.save(user);
        String sessionId = jwtService.generateSession(user);
        var jwtToken = jwtService.generateToken(sessionId);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    @PatchMapping(value = ApiPath.AuthPath.API_AUTH_REGISTER_VALIDATION)
    public ResponseEntity<String> registerValidation(@RequestBody RegisterValidationParam request) {

        return ResponseEntity.ok("Validated to the S3T2 application!");
    }

    @PostMapping(ApiPath.AuthPath.API_AUTH_AUTHENTICATE)
    public AuthenticationDto authenticate(@RequestBody AuthenticationParam request) throws JsonProcessingException {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(request.getEmail());
        if(optionalUserEntity.isEmpty()) {
            throw new BadCredentialsException("Invalid credentials");
        }
        UserEntity userEntity = optionalUserEntity.get();
        if (!passwordService.matchesWithPepper(request.getEmail(), request.getPassword(),
                userEntity.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }
        String sessionId = jwtService.generateSession(userEntity);
        var jwtToken = jwtService.generateToken(sessionId);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }


}
