package com.cyber009.spring3.t0.dto;


import com.cyber009.spring3.t0.common.dto.AddressDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@SuperBuilder
public class OfficeDto extends BaseDto {
    private String name;
    private AddressDto addressDto;
}
