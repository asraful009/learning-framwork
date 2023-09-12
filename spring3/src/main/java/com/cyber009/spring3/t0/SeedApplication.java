package com.cyber009.spring3.t0;

import com.cyber009.spring3.t0.seed.AppUserSeedService;
import com.cyber009.spring3.t0.seed.OfficeSeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SeedApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(SeedApplication.class)
                        .web(WebApplicationType.NONE).run(args);
        runSeedAppUser(context);
        runSeedOffice(context);
        context.close();
    }


    public static void runSeedAppUser(ConfigurableApplicationContext context) {
        AppUserSeedService appUserSeedService = context.getBean(AppUserSeedService.class);
        appUserSeedService.seedAppUser();
    }


    public static void runSeedOffice(ConfigurableApplicationContext context) {
        OfficeSeedService officeSeedService = context.getBean(OfficeSeedService.class);
        officeSeedService.seedOffice();
    }
}
