package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenValidation {

    private RestTemplate restTemplate;

    public TokenValidation(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${application.config.user-management-url}")
    public String user_management_url;

    public Boolean isValidToken(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(
                user_management_url,
                HttpMethod.GET, request, Boolean.class);

        return response.getBody();
    }

}
