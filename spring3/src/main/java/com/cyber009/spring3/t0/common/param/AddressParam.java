package com.cyber009.spring3.t0.common.param;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode
public class AddressParam {

    private String mobile;
    private String email;

    private String addressLine;
    private String city;
    private String country;
    private String postalCode;
}
