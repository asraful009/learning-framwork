package com.cyber009.spring3.t0.common.interceptor;

import com.cyber009.spring3.t0.common.entity.BaseEntity;
import com.cyber009.spring3.t0.common.entity.InstancePermissionNeeded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Iterator;

@Component
@Slf4j
@RequiredArgsConstructor
public class EntityAuditInterceptor implements Interceptor, Serializable {


    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        if(!(entity instanceof InstancePermissionNeeded)) return true;
        log.info("{} -> {}", ((InstancePermissionNeeded) entity).getId(), entity.getClass().getName());
        return true;
    }

    @Override
    public void postFlush(Iterator<Object> entities) {
        entities.forEachRemaining(o -> {
            if(!(o instanceof BaseEntity)) return;
            log.info("{}", o);
        });
    }

}
