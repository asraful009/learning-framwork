package com.cyber009.spring3.t0.common.entity;

import com.cyber009.spring3.t0.common.instance.InstanceCreateEvent;
import jakarta.persistence.PostPersist;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityListener {
    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter mappingJackson2MessageConverter;
    @PostPersist
    public void postPersist(Object entity) {
        if(!(entity instanceof InstancePermissionNeeded)) return;
        rabbitTemplate.setMessageConverter(mappingJackson2MessageConverter);
        InstanceCreateEvent event = InstanceCreateEvent.builder()
                .instanceId(((InstancePermissionNeeded) entity).getId())
                .entityName(entity.getClass().getName())
                .build();
        rabbitTemplate.convertAndSend("spring3-queue", event);
    }
}
