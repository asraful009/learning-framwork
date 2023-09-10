package com.cyber009.spring3.t0.param.appuser;


import com.cyber009.spring3.t0.common.param.AddressParam;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode
public class AppUserParam {
    private String userName;
    private String fullName;
    private String password;
    private AddressParam addressParam;
}
