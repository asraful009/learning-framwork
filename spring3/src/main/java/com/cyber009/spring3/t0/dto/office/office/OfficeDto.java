package com.cyber009.spring3.t0.dto.office.office;


import com.cyber009.spring3.t0.common.dto.AddressDto;
import com.cyber009.spring3.t0.dto.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class OfficeDto extends BaseDto {
    private String name;
    private AddressDto addressDto;
    private OfficeDto parentOfficeDto;
    private List<OfficeDto> childOfficeDtos;
}
