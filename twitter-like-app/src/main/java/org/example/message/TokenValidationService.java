package org.example.message;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TokenValidationService {
    private final WebClient webClient;

    public TokenValidationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("USERMANAGEMENTSERVICE").build();
    }

    public Mono<Boolean> isValidToken(String token) {
        return webClient.get()
                .uri("/api/v1/admin/user")
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(
                        false
                ); // Handle errors gracefully
    }
}

