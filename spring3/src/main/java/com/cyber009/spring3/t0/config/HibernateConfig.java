package com.cyber009.spring3.t0.config;

import com.cyber009.spring3.t0.common.interceptor.EntityAuditInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {
    @Bean
    public EntityAuditInterceptor getBean() {
        return new EntityAuditInterceptor();
    }


}
