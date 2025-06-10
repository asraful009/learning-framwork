package com.cyber009.s3t2.service;

import com.cyber009.s3t2.entity.UserEntity;
import com.cyber009.s3t2.entity.UserHasRoleEntity;
import com.cyber009.s3t2.entity.UserLoginSessionEntity;
import com.cyber009.s3t2.repository.UserSessionRepository;
import com.cyber009.s3t2.utility.GenerateHash;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

@Service
@Slf4j
public class JwtService {

    private final UserSessionRepository userSessionRepository;
    private final String secretKey;
    private final long jwtExpiration;
    private final String pepper;

    public JwtService(
            @Value("${jwt.secret-key}") String secretKey,
            @Value("${jwt.expiration}") long jwtExpiration,
            @Value("${jwt.pepper}") String pepper,
            UserSessionRepository userSessionRepository
    ) {
        this.secretKey = secretKey;
        this.jwtExpiration = jwtExpiration;
        this.pepper = pepper;
        this.userSessionRepository = userSessionRepository;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(String sessionId) {
        return generateToken(new HashMap<>(), sessionId);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            String sessionId
    ) {
        return buildToken(extraClaims, sessionId, jwtExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            String sessionId,
            long expiration
    ) {



        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(sessionId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String sessionId = extractUsername(token);
        Optional<UserLoginSessionEntity> opEntity = userSessionRepository.findOneBySessionId(sessionId);
        if (opEntity.isEmpty()) {
            log.warn("Session not found for token: {}", token);
            return false;
        }
        return (opEntity.get().getEmail().equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        String secretKeyWithPepper = secretKey + pepper;
        byte[] keyBytes = secretKeyWithPepper.getBytes(StandardCharsets.UTF_8); //Decoders.BASE64.decode(secretKeyWithPepper);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateSession(UserEntity userEntity) {
        String secretKeyWithPepper = secretKey + pepper;
        String sessionId = GenerateHash.hashSha512(userEntity.getUsername()
                + LocalDateTime.now()
                + new Random().nextGaussian(),
                secretKeyWithPepper);
        UserLoginSessionEntity entity = UserLoginSessionEntity.builder()
                .sessionId(sessionId)
                .email(userEntity.getUsername())
                .roleJson("[]")
                .build();
        userSessionRepository.save(entity);
        return sessionId;
    }

}
