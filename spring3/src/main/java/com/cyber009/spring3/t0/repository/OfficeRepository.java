package com.cyber009.spring3.t0.repository;


import com.cyber009.spring3.t0.common.repository.CommonRepository;
import com.cyber009.spring3.t0.entity.office.Office;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfficeRepository extends CommonRepository<Office, UUID> {
    Optional<Office> findTopByNameOrderByCreateAt(String name);
}
