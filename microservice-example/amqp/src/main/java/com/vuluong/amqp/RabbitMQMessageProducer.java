package com.vuluong.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingkey) {
        log.info("Publishing to {} using routingKey {}. Payload {}", exchange, routingkey, payload);
        amqpTemplate.convertAndSend(exchange, routingkey, payload);
        log.info("Published to {} using routingKey {}. Payload {}", exchange, routingkey, payload);
    }
}
