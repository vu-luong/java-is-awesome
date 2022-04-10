package com.vuluong.customer.service;

import com.vuluong.amqp.RabbitMQMessageProducer;
import com.vuluong.clients.fraud.FraudCheckResponse;
import com.vuluong.clients.fraud.FraudClient;
import com.vuluong.clients.notification.NotificationRequest;
import com.vuluong.customer.Customer;
import com.vuluong.customer.CustomerRegistrationRequest;
import com.vuluong.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .build();
        // TODO
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse != null && fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: make it async. i.e. add to queue
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setToCustomerId(customer.getId());
        notificationRequest.setToCustomerName(customer.getEmail());
        notificationRequest.setMessage(String.format(
            "Hi %s, welcome to Microservice...",
            customer.getFirstName()
        ));

        rabbitMQMessageProducer.publish(
            notificationRequest,
            "internal.exchange",
            "internal.notification.routing-key"
        );
    }
}
