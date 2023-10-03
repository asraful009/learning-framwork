package com.cyber009.spring3security.dto.response.auth;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@SuperBuilder
@ToString
public class AuthenticationResponse {
    private String fullName;
    private String email;
}
