package com.cyber009.spring3.t0.dto.instance;

import com.cyber009.spring3.t0.dto.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class InstanceWisePermissionDto extends BaseDto {


    @EqualsExclude
    private String instanceFrom;
    private UUID instanceId;

    @EqualsExclude
    private String accessPolicy;

    private List<InstanceWiseAppUserHasPermissionDto> instanceWiseAppUserHasPermissionDtos;
}


