package com.cyber009.spring3.t0;

import com.cyber009.spring3.t0.service.PropertyListerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class T0Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(T0Application.class, args);
//		PropertyListerService propertyListerService = context.getBean(PropertyListerService.class);
//		propertyListerService.listAllProperties();
	}

}
