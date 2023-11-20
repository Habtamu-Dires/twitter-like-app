package org.example.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // get all users
    @GetMapping
    public ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String token){

       if(userService.getAllUsers(token) == null){
           return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
       }
       return ResponseEntity.ok(userService.getAllUsers(token));
    }

}
