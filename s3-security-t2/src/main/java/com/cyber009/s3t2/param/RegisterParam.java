package com.cyber009.s3t2.param;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterParam {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
