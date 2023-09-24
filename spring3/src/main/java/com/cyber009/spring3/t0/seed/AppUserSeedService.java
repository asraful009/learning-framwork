package com.cyber009.spring3.t0.seed;

import com.cyber009.spring3.t0.common.param.AddressParam;
import com.cyber009.spring3.t0.param.appuser.AppUserParam;
import com.cyber009.spring3.t0.service.WebService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserSeedService {
    private final WebService webService;

    public void seedAppUser() {
        Faker faker = new Faker();
        List<AppUserParam> params = new LinkedList<>();
        for(int i = 0; i<faker.number().numberBetween(100, 100); i++ ) {
            params.add(AppUserParam.builder()
                    .userName(faker.name().username())
                    .fullName(faker.name().fullName())
                    .addressParam(AddressParam.builder()
                            .mobile(faker.phoneNumber().cellPhone())
                            .email(faker.internet().emailAddress())
                            .addressLine(faker.address().fullAddress())
                            .city(faker.address().city())
                            .country(faker.address().country())
                            .postalCode(faker.address().zipCode())
                            .build())
                    .password(faker.internet().password())
                    .build());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        for(int i = 0; i<params.size(); i++ ) {
            try {

                json = objectMapper.writeValueAsString(params.get(i));
                log.info("json: {}", json);
                Optional<String> opRes = webService.postDataToApi("/app-user", json).blockOptional();
                log.info("param: {} -> {}", json, opRes);

            } catch (JsonProcessingException e) {
                log.error(e.getMessage());
            }
        }
    }

}
