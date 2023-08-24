package com.cyber009.spring3.t0.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WebService {
    private final WebClient webClient;

    @Autowired
    public WebService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9090").build();
    }

    public Mono<String> postDataToApi(String endpoint, String requestBody) {
        return webClient.post()
                .uri(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestBody))
                .exchangeToMono(clientResponse -> {
                   if(clientResponse.statusCode().equals(HttpStatus.OK)) {
                       return clientResponse.bodyToMono(String.class);
                   } else {
                       return clientResponse.createException().flatMap(Mono::error);
                   }
                });
    }
}
