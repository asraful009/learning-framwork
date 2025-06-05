package com.cyber009.s3t2.repository;

import com.cyber009.s3t2.entity.EndPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EndPointRepository extends JpaRepository<EndPointEntity, Integer> {
    Boolean existsByName(String name);
}