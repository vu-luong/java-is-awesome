package com.vuluong.notification.consumer;

import com.vuluong.clients.notification.NotificationRequest;
import com.vuluong.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(NotificationRequest request) {
        log.info("Consumed {} from queue", notificationService);
        notificationService.send(request);
    }
}
