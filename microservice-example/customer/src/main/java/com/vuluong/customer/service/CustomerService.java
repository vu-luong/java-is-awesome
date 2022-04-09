package com.vuluong.customer.service;

import com.vuluong.customer.Customer;
import com.vuluong.customer.CustomerRegistrationRequest;
import com.vuluong.customer.CustomerRepository;
import com.vuluong.customer.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .build();
        // TODO
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
            "http://FRAUD/api/v1/fraud-check/{customerId}",
            FraudCheckResponse.class,
            customer.getId()
        );

        if (fraudCheckResponse != null && fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
