package org.example.subscriberproducer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ProducerSubscriber")
public class SubscriberProducer {

    private Integer SP_ID;
    private Integer subscriberId;
    private Integer producerId;
}
