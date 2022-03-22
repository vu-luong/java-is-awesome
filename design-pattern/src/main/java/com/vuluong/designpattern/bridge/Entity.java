package com.vuluong.designpattern.bridge;

public interface Entity {
    String getId();

    void setId(String id);
}

class UserEntity implements Entity {
    private String id;
    private String username;

    public UserEntity(String id, String username) {
        this.id       = id;
        this.username = username;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User (" + "id='" + id + ", username='" + username + ')';
    }
}
