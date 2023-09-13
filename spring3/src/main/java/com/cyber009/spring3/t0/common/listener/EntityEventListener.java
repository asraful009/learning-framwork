package com.cyber009.spring3.t0.common.listener;


import com.cyber009.spring3.t0.common.entity.BaseEntity;
import jakarta.persistence.PostPersist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EntityEventListener {

    @PostPersist
    public void postPersist(Object entity) {

    }

    private void emit(BaseEntity entity) {

    }
}
