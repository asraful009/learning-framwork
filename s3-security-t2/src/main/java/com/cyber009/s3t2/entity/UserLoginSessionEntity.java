package com.cyber009.s3t2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_login_sessions", indexes = {
        @Index(name = "idx_session_id", columnList = "sessionId", unique = true)})
public class UserLoginSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 1024)
    private String sessionId;

    @Column(nullable = false, length = 1024)
    private String email;

    @Lob
    private String roleJson;

}
