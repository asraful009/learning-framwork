package com.cyber009.spring3.t0.repository.instance;


import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermissionRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InstanceWisePermissionRedisRepository extends CrudRepository<InstanceWisePermissionRedis, UUID> {

}
