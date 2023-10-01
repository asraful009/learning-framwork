package com.cyber009.spring3security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtService {

    public String extractEmail(String jwtToken) {
        return null;
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts.parserBuilder().setSigningKey(new byte[] { 65 }).build().parseClaimsJws(jwtToken).getBody();
    }
}
