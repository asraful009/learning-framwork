package com.cyber009.spring3.t0.listener;

import com.cyber009.spring3.t0.common.instance.InstanceCreateEvent;
import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.service.InstanceWisePermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InstanceWisePermissionListener {
    private final InstanceWisePermissionService instanceWisePermissionService;

    @RabbitListener(queues = "spring3-queue")
    public void receiveMessage(InstanceCreateEvent event) {
        System.out.println("Received message: " + event);
        InstanceWisePermissionDto dto = instanceWisePermissionService.save(event);
        log.info("dto: {}", dto);
    }
}
