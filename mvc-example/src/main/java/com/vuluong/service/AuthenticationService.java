package com.vuluong.service;

import com.vuluong.exception.AuthenticationException;
import com.vuluong.manager.BeanManager;
import com.vuluong.model.AccessTokenModel;
import com.vuluong.model.LoginModel;
import com.vuluong.model.UserModel;

public class AuthenticationService {

    private final UserService userService = BeanManager.getInstance()
        .getBean(UserService.class);

    public AccessTokenModel authenticate(LoginModel model) {
        UserModel userModel = userService.getUserByUsername(model.getUsername());
        if (userModel == null || !model.getPassword().equals(userModel.getPassword())) {
            throw new AuthenticationException();
        }
        return userService.getAccessTokenByUserId(
            userModel.getId()
        );
    }
}
