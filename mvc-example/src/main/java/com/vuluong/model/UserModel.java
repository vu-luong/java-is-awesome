package com.vuluong.model;

public class UserModel {

    private final long id;
    private final String username;
    private final String password;

    public UserModel(long id, String username, String password) {
        this.id       = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
