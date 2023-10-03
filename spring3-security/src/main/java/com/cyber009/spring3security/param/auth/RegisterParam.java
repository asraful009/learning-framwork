package com.cyber009.spring3security.param.auth;


import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@SuperBuilder
@ToString
public class RegisterParam {
    private String fullName;
    private String email;
    private String password;
}
