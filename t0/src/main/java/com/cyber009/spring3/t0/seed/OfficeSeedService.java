package com.cyber009.spring3.t0.seed;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OfficeSeedService {
    private final WebClient webClient;
    public OfficeSeedService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("").build();
    }

    public String fetchData() {
        return webClient.get().uri("/endpoint").retrieve().bodyToMono(String.class).block();
    }
    public void seedOffice() {


    }
}
