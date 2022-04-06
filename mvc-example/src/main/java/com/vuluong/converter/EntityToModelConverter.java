package com.vuluong.converter;

import com.vuluong.entity.AccessToken;
import com.vuluong.entity.User;
import com.vuluong.model.AccessTokenModel;
import com.vuluong.model.UserModel;

public class EntityToModelConverter {

    public UserModel toModel(User user) {
        if (user == null) {
            return null;
        }
        return new UserModel(
            user.getId(),
            user.getUsername(),
            user.getPassword()
        );
    }

    public AccessTokenModel toModel(AccessToken accessToken) {
        return new AccessTokenModel(
            accessToken.getAccessToken()
        );
    }
}
