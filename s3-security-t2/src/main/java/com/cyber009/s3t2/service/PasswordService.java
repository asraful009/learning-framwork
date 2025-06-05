package com.cyber009.s3t2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PasswordService {

    private final PasswordEncoder passwordEncoder;
    private final String pepper;

    public PasswordService(PasswordEncoder passwordEncoder,
                           @Value("${jwt.pepper}") String pepper) {
        this.passwordEncoder = passwordEncoder;
        this.pepper = pepper;
    }

    public String encodeWithPepper(String email, String rawPassword) {
        return passwordEncoder.encode(email + rawPassword + pepper);
    }

    public boolean matchesWithPepper(String email, String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(email + rawPassword + pepper, encodedPassword);
    }

}
