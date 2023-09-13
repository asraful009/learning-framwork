package com.cyber009.spring3.t0.common.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("ApplicationContextProvider")
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;
    /**
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    public static Object getBean(Class clazz) {
        return ApplicationContextProvider.CONTEXT.getBean(clazz);
    }

    public static Object getBean(String qualifier, Class clazz) {
        return ApplicationContextProvider.CONTEXT.getBean(qualifier, clazz);
    }
}
