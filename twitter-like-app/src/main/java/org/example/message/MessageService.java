package org.example.message;

import lombok.AllArgsConstructor;
import org.example.config.TokenValidation;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MessageService {

    private MessageRepository repository;
    private TokenValidation tokenValidation;
    private TokenValidationService tokenValidationService;

    public Flux<Message> getAllMessages(String token) {
        try{
            Boolean isValid = tokenValidation.isValidToken(token);
            if(isValid)  return repository.findAll();
            return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Flux<Message> froSpecificSubscriber(Integer subscriberId, String token){
        try{
            Boolean isValid = tokenValidation.isValidToken(token);
            if(isValid)   return repository.forSpecificSubscriber(subscriberId);
            return null;
        } catch (Exception e){
            return null;
        }
    }

    public Flux<Message> getByProducer(Integer producerId, String token){
        try{
            Boolean isValid = tokenValidation.isValidToken(token);
            if(isValid)   return repository.findByUid(producerId);
            return null;
        } catch (Exception e){
            return null;
        }
    }
}
