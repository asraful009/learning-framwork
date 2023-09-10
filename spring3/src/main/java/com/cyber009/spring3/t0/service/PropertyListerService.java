package com.cyber009.spring3.t0.service;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropertyListerService {
    private final Environment environment;

    public PropertyListerService(Environment environment) {
        this.environment = environment;
    }

    public void listAllProperties() {
        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment) environment;
            for (org.springframework.core.env.PropertySource<?> propertySource : configurableEnvironment.getPropertySources()) {
                if (propertySource instanceof EnumerablePropertySource) {
                    EnumerablePropertySource<?> enumerablePropertySource = (EnumerablePropertySource<?>) propertySource;
                    String[] propertyNames = enumerablePropertySource.getPropertyNames();
                    if (propertyNames != null) {
                        for (String propertyName : propertyNames) {
                            String propertyValue = environment.getProperty(propertyName);
                            System.out.println(propertyName + " = " + propertyValue);
                        }
                    }
                }
            }
        }
    }
}
