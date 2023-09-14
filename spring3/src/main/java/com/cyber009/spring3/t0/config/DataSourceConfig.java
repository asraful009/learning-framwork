package com.cyber009.spring3.t0.config;

import com.cyber009.spring3.t0.common.interceptor.EntityAuditInterceptor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration

public class DataSourceConfig {
    @Autowired
    private DataSource dataSource; // Inject your data source

    @Bean
    public Interceptor hibernateInterceptor() {
        return new EntityAuditInterceptor();
    }



}
