package com.cyber009.spring3.t0.param.office.appointment;

import com.cyber009.spring3.t0.common.param.BaseSearchParam;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SearchAppointmentParam extends BaseSearchParam {
    @Builder.Default
    private UUID officeId = null;
    @Builder.Default
    private String name = "";
}
