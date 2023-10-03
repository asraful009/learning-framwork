package com.cyber009.spring3security.service.appuser;

import com.cyber009.spring3security.entity.appuser.AppUser;
import com.cyber009.spring3security.enums.Role;
import com.cyber009.spring3security.param.auth.RegisterParam;
import com.cyber009.spring3security.repository.appuser.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findOneByEmail(email);
    }

    public AppUser register(RegisterParam param) {
        AppUser appUser = AppUser.builder()
                .email(param.getEmail())
                .fullName(param.getFullName())
                .password(passwordEncoder.encode(param.getPassword()))
                .role(Role.USER)
                .build();
        appUser = appUserRepository.save(appUser);
        return appUser;
    }

    public AppUser authenticate(RegisterParam param) {
        AppUser appUser = AppUser.builder()
                .build();
        return null;
    }
}
