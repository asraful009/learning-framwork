package com.cyber009.spring3.t0.param.instance;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode
public class InstanceWisePermissionParam {
    private String accessPolicy;
    private List<InstanceWiseAppUserHasPermissionParam> instanceWiseAppUserHasPermissionParams;
    private List<InstanceWiseAppointmentHasPermissionParam> instanceWiseAppointmentHasPermissionParams;
}
