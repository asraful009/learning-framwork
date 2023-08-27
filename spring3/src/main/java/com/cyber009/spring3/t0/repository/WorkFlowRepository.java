package com.cyber009.spring3.t0.repository;


import com.cyber009.spring3.t0.common.repository.CommonRepository;
import com.cyber009.spring3.t0.entity.Office;
import com.cyber009.spring3.t0.entity.WorkFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkFlowRepository extends CommonRepository<WorkFlow, UUID> {
    Optional<WorkFlow> findTopByTitleOrderByCreateAt(String title);

}
