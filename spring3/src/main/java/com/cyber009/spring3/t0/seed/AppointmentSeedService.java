package com.cyber009.spring3.t0.seed;

import com.cyber009.spring3.t0.dto.office.office.OfficeDto;
import com.cyber009.spring3.t0.param.office.appointment.AppointmentParam;
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
public class AppointmentSeedService {
    private final WebService webService;

    public void seedAppointment() {
        Faker faker = new Faker();
        List<AppointmentParam> params = new LinkedList<>();
        for(int i = 0; i<faker.number().numberBetween(8, 8); i++ ) {
            params.add(AppointmentParam.builder()
                    .name(faker.company().name())
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

//    private void getOffices() {
//        List<OfficeDto> officeDtos = new LinkedList<>();
//        webService.getDataToApi("/office", null).blockOptional();
//    }

}
