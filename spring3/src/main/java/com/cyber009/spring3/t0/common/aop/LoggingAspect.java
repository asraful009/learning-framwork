package com.cyber009.spring3.t0.common.aop;



import com.cyber009.spring3.t0.common.entity.InstancePermissionNeeded;
import com.cyber009.spring3.t0.common.instance.InstanceCreateEvent;
import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.service.Instancewisepermission.InstanceWisePermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {
    private final InstanceWisePermissionService instanceWisePermissionService;
    @AfterReturning(value = "execution(* com.cyber009.spring3.t0.common.entity.EntityListener.postPersist(..))", returning = "entity")
    public void logBefore(JoinPoint joinPoint, Object entity) {
        log.info("Entering method: {} -> {}", joinPoint.getSignature().getName(), entity);
        if(!(entity instanceof InstancePermissionNeeded)) return;
        InstanceCreateEvent event = InstanceCreateEvent.builder()
                .instanceId(((InstancePermissionNeeded) entity).getId())
                .entityName(entity.getClass().getName())
                .build();
        InstanceWisePermissionDto dto = instanceWisePermissionService.save(event);
        log.info("dto:{}", dto);
    }
}
