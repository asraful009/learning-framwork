package com.cyber009.spring3security.service;

import com.cyber009.spring3security.entity.appuser.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtService {
    private final String SECRET_KEY = "c3ed4c48b0fcedf563920c08e982775a6504e6332913a483d7aceb61a2f79717";
    public String extractEmail(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    public String generateJwtToken(AppUser appUser) {
        return generateJwtToken(new HashMap<>(), appUser);
    }

    public String generateJwtToken(Map<String, Object> extractClaims, AppUser appUser) {
        Date dt = new Date(System.currentTimeMillis());
        Date dtExp = new Date(System.currentTimeMillis() + (1000 * 60 * 24));

        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(appUser.getEmail())
                .setIssuedAt(dt)
                .setExpiration(dtExp)
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean isJwtTokenValid(String jwtToken, AppUser appUser) {
        final String email = extractEmail(jwtToken);
        return (email.equals(appUser.getEmail()) && !isTokenExpire(jwtToken));
    }

    private boolean isTokenExpire(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration);
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts
                .parserBuilder().setSigningKey(getSignatureKey()).build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getSignatureKey() {
        byte [] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
