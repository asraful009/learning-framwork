package com.cyber009.spring3.t0.common.dto;


import com.cyber009.spring3.t0.dto.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class AddressDto extends BaseDto {
    private String mobile;
    private String email;

    private String addressLine;
    private String city;
    private String country;
    private String postalCode;
}
