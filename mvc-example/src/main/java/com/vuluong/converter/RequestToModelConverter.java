package com.vuluong.converter;

import com.vuluong.model.LoginModel;
import com.vuluong.request.LoginRequest;

public class RequestToModelConverter {

    public LoginModel toModel(LoginRequest request) {
        return new LoginModel(
            request.getUsername(),
            request.getPassword()
        );
    }
}
