package com.cyber009.spring3.t0.seed;

import com.cyber009.spring3.t0.param.OfficeParam;
import com.cyber009.spring3.t0.service.WebService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfficeSeedService {
    private final WebService webService;

    public void seedOffice() {
        Faker faker = new Faker();
        OfficeParam param = OfficeParam.builder().build();
        param.setName(faker.name().fullName());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(param);
            Optional<String> opRes = webService.postDataToApi("/office", json).blockOptional();
            log.info("param: {} -> {}", json, opRes);

        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

}
