package com.cyber009.spring3.t0.common.instance;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
@Slf4j
@ToString
public class InstanceCreateEvent extends ApplicationEvent {
    private final UUID instanceId;
    private final String entityName;

    public InstanceCreateEvent(Object source, UUID instanceId, String entityName) {
        super(source);
        this.instanceId = instanceId;
        this.entityName = entityName;
    }

}
