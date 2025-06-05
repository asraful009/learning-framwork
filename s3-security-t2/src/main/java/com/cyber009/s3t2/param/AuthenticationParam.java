package com.cyber009.s3t2.param;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationParam {
    private String email;
    private String password;
}
