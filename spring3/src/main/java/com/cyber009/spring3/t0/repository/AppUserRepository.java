package com.cyber009.spring3.t0.repository;


import com.cyber009.spring3.t0.common.repository.CommonRepository;
import com.cyber009.spring3.t0.entity.AppUser;
import com.cyber009.spring3.t0.entity.Office;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppUserRepository extends CommonRepository<AppUser, UUID> {
    Optional<AppUser> findTopByNameOrderByCreateAt(String name);
}
