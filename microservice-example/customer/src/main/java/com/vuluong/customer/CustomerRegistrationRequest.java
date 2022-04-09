package com.vuluong.customer;

import lombok.Data;

@Data
public class CustomerRegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
}
