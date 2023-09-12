package com.cyber009.spring3.t0.seed;

import com.cyber009.spring3.t0.common.param.AddressParam;
import com.cyber009.spring3.t0.param.office.OfficeParam;
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
public class OfficeSeedService {
    private final WebService webService;

    public void seedOffice() {
        Faker faker = new Faker();
        List<OfficeParam> params = new LinkedList<>();
        for(int i = 0; i<faker.number().numberBetween(1, 1); i++ ) {
            params.add(OfficeParam.builder()
                    .name(faker.company().name())
                    .addressParam(AddressParam.builder()
                            .mobile(faker.phoneNumber().cellPhone())
                            .email(faker.internet().emailAddress())
                            .addressLine(faker.address().fullAddress())
                            .city(faker.address().city())
                            .country(faker.address().country())
                            .postalCode(faker.address().zipCode())
                            .build())
                    .build());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        for(int i = 0; i<params.size(); i++ ) {
            try {

                json = objectMapper.writeValueAsString(params.get(i));
                Optional<String> opRes = webService.postDataToApi("/office", json).blockOptional();
                log.info("param: {} -> {}", json, opRes);

            } catch (JsonProcessingException e) {
                log.error(e.getMessage());
            }
        }
    }

}
