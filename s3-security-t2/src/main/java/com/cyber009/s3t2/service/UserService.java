package com.cyber009.s3t2.service;

import com.cyber009.s3t2.entity.UserLoginSessionEntity;
import com.cyber009.s3t2.repository.UserRepository;
import com.cyber009.s3t2.repository.UserSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    public UserLoginSessionEntity loadUserBySessionId(String sessionId) throws UsernameNotFoundException {
        return userSessionRepository.findOneBySessionId(sessionId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
