package com.cyber009.s3t2.repository;

import com.cyber009.s3t2.entity.UserEntity;
import com.cyber009.s3t2.entity.UserLoginSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSessionRepository extends JpaRepository<UserLoginSessionEntity, Integer> {
    Optional<UserLoginSessionEntity> findOneBySessionId(String sessionId);
}