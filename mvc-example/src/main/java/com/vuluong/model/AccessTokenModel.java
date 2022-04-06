package com.vuluong.model;

public class AccessTokenModel {
    private final String accessToken;

    public AccessTokenModel(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
