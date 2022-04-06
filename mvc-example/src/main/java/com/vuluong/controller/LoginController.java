package com.vuluong.controller;

import com.vuluong.converter.RequestToModelConverter;
import com.vuluong.manager.BeanManager;
import com.vuluong.model.AccessTokenModel;
import com.vuluong.request.LoginRequest;
import com.vuluong.response.LoginResponse;
import com.vuluong.service.AuthenticationService;
import com.vuluong.validator.LoginValidator;

public class LoginController {

    private final AuthenticationService authenticationService = BeanManager.getInstance()
        .getBean(AuthenticationService.class);
    private final LoginValidator loginValidator = BeanManager.getInstance()
        .getBean(LoginValidator.class);
    private final RequestToModelConverter requestToModelConverter = BeanManager.getInstance()
        .getBean(RequestToModelConverter.class);

    // @DoPost("/login")
    public LoginResponse loginPost(LoginRequest request) {
        loginValidator.validate(request);
        AccessTokenModel accessTokenModel = authenticationService.authenticate(
            requestToModelConverter.toModel(request)
        );
        return new LoginResponse(accessTokenModel.getAccessToken());
    }
}
