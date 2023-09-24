package com.cyber009.spring3.t0.dto.office.appointment;


import com.cyber009.spring3.t0.dto.BaseDto;
import com.cyber009.spring3.t0.dto.office.office.OfficeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class AppointmentDto extends BaseDto {
    private String name;
    private OfficeDto officeDto;
}
