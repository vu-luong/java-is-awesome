package com.vuluong.notification.service;

import com.vuluong.clients.notification.NotificationRequest;
import com.vuluong.notification.entity.Notification;
import com.vuluong.notification.repo.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest request) {
        notificationRepository.save(
            Notification.builder()
                .toCustomerId(request.getToCustomerId())
                .toCustomerEmail(request.getToCustomerName())
                .sender("Vu Luong")
                .message(request.getMessage())
                .sentAt(LocalDateTime.now())
                .build()
        );
    }
}
