package com.cyber009.spring3security.repository.appuser;

import com.cyber009.spring3security.entity.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    Optional<AppUser> findOneByUserName(String userName);
}
