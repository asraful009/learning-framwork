package com.cyber009.spring3security.service;

import com.cyber009.spring3security.entity.appuser.AppUser;
import com.cyber009.spring3security.repository.appuser.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findOneByEmail(email);
    }
}
