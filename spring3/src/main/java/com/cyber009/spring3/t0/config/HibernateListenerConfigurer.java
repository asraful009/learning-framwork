package com.cyber009.spring3.t0.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateListenerConfigurer {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private AuditLogListener auditLogListener;


    @PostConstruct
    protected void init() {
        SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(auditLogListener);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(auditLogListener);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(auditLogListener);
    }

}
