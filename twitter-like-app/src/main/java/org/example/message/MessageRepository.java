package org.example.message;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface MessageRepository extends ReactiveCrudRepository<Message, Integer> {


    @Query(" SELECT M.* FROM t_messages M JOIN subscriberproducer " +
            "SP ON M.uid = SP.producerid WHERE SP.subscriberid = :subscriberId"
    )
    Flux<Message> forSpecificSubscriber(@Param("subscriberId") Integer subscriberId);

    Flux<Message> findByUid(Integer producerId);
}
