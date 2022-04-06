package com.vuluong;

import com.vuluong.controller.LoginController;
import com.vuluong.converter.EntityToModelConverter;
import com.vuluong.converter.RequestToModelConverter;
import com.vuluong.manager.BeanManager;
import com.vuluong.repository.AccessTokenRepository;
import com.vuluong.repository.UserRepository;
import com.vuluong.request.LoginRequest;
import com.vuluong.response.LoginResponse;
import com.vuluong.service.AuthenticationService;
import com.vuluong.service.UserService;
import com.vuluong.validator.LoginValidator;

public class Application {

    public static void main(String[] args) {
        initializeBeans();
        testLogin();
    }

    private static void testLogin() {
        LoginRequest request = new LoginRequest(null, "123456");
        LoginController controller = BeanManager.getInstance().getBean(LoginController.class);
        LoginResponse response = controller.loginPost(request);
        System.out.println(response);
    }

    private static void initializeBeans() {
        BeanManager beanManager = BeanManager.getInstance();
        beanManager.addBean(AccessTokenRepository.class, new AccessTokenRepository());
        beanManager.addBean(UserRepository.class, new UserRepository());
        beanManager.addBean(EntityToModelConverter.class, new EntityToModelConverter());
        beanManager.addBean(RequestToModelConverter.class, new RequestToModelConverter());
        beanManager.addBean(UserService.class, new UserService());
        beanManager.addBean(AuthenticationService.class, new AuthenticationService());
        beanManager.addBean(LoginValidator.class, new LoginValidator());
        beanManager.addBean(LoginController.class, new LoginController());
    }
}
