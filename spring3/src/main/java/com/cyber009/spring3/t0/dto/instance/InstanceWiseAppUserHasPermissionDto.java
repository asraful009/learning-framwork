package com.cyber009.spring3.t0.dto.instance;

import com.cyber009.spring3.t0.common.entity.BaseEntity;
import com.cyber009.spring3.t0.dto.BaseDto;
import com.cyber009.spring3.t0.entity.InstanceWisePermission;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class InstanceWiseAppUserHasPermissionDto extends BaseDto {

    @EqualsExclude
    private InstanceWisePermission instanceWisePermission;

    @EqualsExclude
    private UUID appUserId;

    private String method;

    @EqualsExclude
    private Integer sortingOrder;
}


