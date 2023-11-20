package org.example.user;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    @Query("SELECT * FROM t_users WHERE u_name= ?")
    Optional<User> findByName( String name);

    @Query("SELECT * FROM t_users WHERE u_role='Producer'")
    Flux<User> findAllProducers();

    @Query("SELECT * FROM t_users WHERE u_role='Subscriber'")
    Flux<User> findAllSubscribers();
}
