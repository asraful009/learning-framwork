package com.cyber009.s3t2.param;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterValidationParam {
    private String token;
    private String otp;
}
