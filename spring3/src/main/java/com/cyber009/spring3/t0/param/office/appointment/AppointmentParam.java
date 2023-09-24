package com.cyber009.spring3.t0.param.office.appointment;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode
public class AppointmentParam {
    private UUID officeId;
    private String name;
}
