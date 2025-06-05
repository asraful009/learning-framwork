package com.cyber009.s3t2.controller;

import com.cyber009.s3t2.dto.AuthenticationDto;
import com.cyber009.s3t2.entity.UserEntity;
import com.cyber009.s3t2.param.AuthenticationParam;
import com.cyber009.s3t2.param.RegisterParam;
import com.cyber009.s3t2.repository.UserRepository;
import com.cyber009.s3t2.service.JwtService;
import com.cyber009.s3t2.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public AuthenticationDto register(@RequestBody RegisterParam request) {
        var user = UserEntity.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordService.encodeWithPepper(request.getEmail(), request.getPassword()))
                .role("USER")
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    @PostMapping("/authenticate")
    public AuthenticationDto authenticate(@RequestBody AuthenticationParam request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(request.getEmail());
        if(optionalUserEntity.isEmpty()) {
            throw new BadCredentialsException("Invalid credentials");
        }
        UserEntity userEntity = optionalUserEntity.get();
        if (!passwordService.matchesWithPepper(request.getEmail(), request.getPassword(),
                userEntity.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }
        var jwtToken = jwtService.generateToken(userEntity);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }
}
