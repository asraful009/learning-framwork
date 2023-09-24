package com.cyber009.spring3.t0.repository.office;


import com.cyber009.spring3.t0.common.repository.CommonRepository;
import com.cyber009.spring3.t0.entity.office.Appointment;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends CommonRepository<Appointment, UUID> {
    Optional<Appointment> findTopByNameOrderByCreateAt(String name);
}
