package com.cyber009.spring3.t0.entity.instancewisepermission;

import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RedisHash("instance_wise_permission_redis")
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

    @TimeToLive(unit = TimeUnit.MINUTES)
    @Builder.Default
    private Integer ttl = 5;


}
