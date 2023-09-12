package com.cyber009.spring3.t0.param.instance;


import com.cyber009.spring3.t0.common.param.AddressParam;
import com.cyber009.spring3.t0.entity.InstanceWiseAppUserHasPermission;
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
}
