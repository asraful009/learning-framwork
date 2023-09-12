package com.cyber009.spring3.t0.listener.Instance;


import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.event.instance.InstanceCreateEvent;
import com.cyber009.spring3.t0.service.InstanceWisePermissionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InstanceEventListener implements ApplicationListener<InstanceCreateEvent> {

    private final InstanceWisePermissionService instanceWisePermissionService;
    /**
     * @param event InstanceCreateEvent
     */
    @Override
    public void onApplicationEvent(@NonNull InstanceCreateEvent event) {
        InstanceWisePermissionDto dto = instanceWisePermissionService.save(event);
        log.info("event-> dto: {} -> {}", event, dto);
    }
}
