package com.cyber009.spring3.t0.entity.instancewisepermission;

import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@RedisHash
@Data
@SuperBuilder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class InstanceWisePermissionRedis implements Serializable {
    @Id
    private UUID id;
    private InstanceWisePermissionDto instanceWisePermissionDto;


}
