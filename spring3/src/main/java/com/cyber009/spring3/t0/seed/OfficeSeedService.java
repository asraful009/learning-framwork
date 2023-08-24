package com.cyber009.spring3.t0.seed;

import com.cyber009.spring3.t0.param.OfficeParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OfficeSeedService {

    public void seedOffice() {
        Faker faker = new Faker();
        OfficeParam param = OfficeParam.builder().build();
        param.setName(faker.name().fullName());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(param);
            log.info("param: {}", json);

        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

}
