package com.cyber009.spring3.t0.repository.instance;


import com.cyber009.spring3.t0.common.repository.CommonRepository;
import com.cyber009.spring3.t0.entity.instancewisepermission.InstanceWisePermission;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InstanceWisePermissionRepository extends CommonRepository<InstanceWisePermission, UUID> {
    Optional<InstanceWisePermission> findTopByInstanceFromAndInstanceIdOrderByCreateAt(String InstanceFrom, UUID InstanceId);
}
