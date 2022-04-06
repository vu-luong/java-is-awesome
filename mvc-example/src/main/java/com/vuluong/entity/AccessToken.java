package com.vuluong.entity;

public class AccessToken {

    private long id;
    private long userId;
    private String accessToken;
    private long expiredTime;

    public AccessToken() {}

    public AccessToken(long id, long userId, String accessToken, long expiredTime) {
        this.id          = id;
        this.userId      = userId;
        this.accessToken = accessToken;
        this.expiredTime = expiredTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
