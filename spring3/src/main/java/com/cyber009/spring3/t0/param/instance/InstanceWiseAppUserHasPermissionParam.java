package com.cyber009.spring3.t0.param.instance;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode
public class InstanceWiseAppUserHasPermissionParam {
    private UUID appUserId;

    @EqualsExclude
    private String method;
}


