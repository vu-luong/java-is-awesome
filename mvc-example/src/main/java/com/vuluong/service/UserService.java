package com.vuluong.service;

import com.vuluong.converter.EntityToModelConverter;
import com.vuluong.entity.AccessToken;
import com.vuluong.entity.User;
import com.vuluong.manager.BeanManager;
import com.vuluong.model.AccessTokenModel;
import com.vuluong.model.UserModel;
import com.vuluong.repository.AccessTokenRepository;
import com.vuluong.repository.UserRepository;

import java.util.UUID;

public class UserService {

    private final UserRepository userRepository = BeanManager.getInstance()
        .getBean(UserRepository.class);
    private final AccessTokenRepository accessTokenRepository = BeanManager.getInstance()
        .getBean(AccessTokenRepository.class);
    private final EntityToModelConverter entityToModelConverter = BeanManager.getInstance()
        .getBean(EntityToModelConverter.class);

    private static final long TOKEN_TIME_PERIOD_7_DAYS = 7 * 24 * 60 * 60 * 1000;

    public UserModel getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return entityToModelConverter.toModel(user);
    }

    public AccessTokenModel getAccessTokenByUserId(long userId) {
        AccessToken accessToken = accessTokenRepository.findByUserId(userId);
        if (accessToken == null || accessToken.getExpiredTime() < System.currentTimeMillis()) {
            accessToken = generateAccessTokenAndSave(userId);
        }
        return entityToModelConverter.toModel(accessToken);
    }

    private AccessToken generateAccessTokenAndSave(long userId) {
        AccessToken accessToken = new AccessToken();
        accessToken.setUserId(userId);
        accessToken.setExpiredTime(System.currentTimeMillis() + TOKEN_TIME_PERIOD_7_DAYS);
        accessToken.setAccessToken(generateAccessToken());
        accessTokenRepository.save(accessToken);
        return accessToken;
    }

    private String generateAccessToken() {
        return UUID.randomUUID().toString();
    }
}
