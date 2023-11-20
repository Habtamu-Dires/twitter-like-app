package org.example.subscriberproducer;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SPRepository extends ReactiveCrudRepository<SubscriberProducer, Integer> {
}
