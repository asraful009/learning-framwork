package com.cyber009.s3t2.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationDto {
    private String token;
}
