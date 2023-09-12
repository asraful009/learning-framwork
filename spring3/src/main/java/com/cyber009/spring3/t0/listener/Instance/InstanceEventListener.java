package com.cyber009.spring3.t0.listener.Instance;


import com.cyber009.spring3.t0.event.instance.InstanceCreateEvent;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InstanceEventListener implements ApplicationListener<InstanceCreateEvent> {


    /**
     * @param event InstanceCreateEvent
     */
    @Override
    public void onApplicationEvent(@NonNull InstanceCreateEvent event) {
        log.info("event: {}", event);
    }
}
