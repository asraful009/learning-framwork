package com.cyber009.spring3.t0;

import com.cyber009.spring3.t0.seed.OfficeSeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cyber009.spring3.t0.seed")
@RequiredArgsConstructor
@Slf4j
public class SeedApplication {
    private final OfficeSeedService officeSeedService;
    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder =
                new SpringApplicationBuilder(SeedApplication.class)
                        .web(WebApplicationType.NONE);
        applicationBuilder.run(args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            officeSeedService.seedOffice();
        };
    }
}
