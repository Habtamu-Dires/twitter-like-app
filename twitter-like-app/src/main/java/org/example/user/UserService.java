package org.example.user;


import lombok.AllArgsConstructor;
import org.example.config.TokenValidation;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private TokenValidation tokenValidation;

    public  Flux<User> getAllUsers(String token) {
        try{
            Boolean isValid = tokenValidation.isValidToken(token);
            System.out.println("The token " + token);
            if(isValid)  return repository.findAll();
            return null;
        } catch (Exception e){
            return null;
        }
    }

}
