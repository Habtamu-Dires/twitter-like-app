package org.example.message;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/messages")
@AllArgsConstructor
public class MessageController {

    private MessageService messageService;

    @GetMapping
    public ResponseEntity<?> getAllMessages(@RequestHeader("Authorization") String token){
        if(messageService.getAllMessages(token) == null){
            return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
        }
        return ResponseEntity.ok(messageService.getAllMessages(token));
    }

    //BY specific producer
    @GetMapping("by-producer/{producer-id}")
    public ResponseEntity<?> getByProducer(
            @PathVariable("producer-id") Integer producerId,
            @RequestHeader("Authorization") String token){

        if(messageService.getByProducer(producerId, token) == null){
            return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
        }
        return ResponseEntity.ok(messageService.getByProducer(producerId,token));
    }

    //By specific subscriber
    @GetMapping("by-subscriber/{subscriber-id}")
    public ResponseEntity<?>  getBySubscriber(
            @PathVariable("subscriber-id") Integer subscriberId,
            @RequestHeader("Authorization") String token
    ){
        if(messageService.froSpecificSubscriber(subscriberId, token) == null){
            return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
        }
        return ResponseEntity.ok(
                messageService.froSpecificSubscriber(subscriberId, token)
        );
    }

}
