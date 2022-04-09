package com.vuluong.clients.notification;

import lombok.Data;

@Data
public class NotificationRequest {

    private Integer toCustomerId;
    private String toCustomerName;
    private String message;
}
