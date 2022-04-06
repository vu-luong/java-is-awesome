package com.vuluong.repository;

import com.vuluong.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {
    private final Map<Long, User> userById = new ConcurrentHashMap<>();
    private final Map<String, User> userByUsernameIndex = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public UserRepository() {
        save(new User(0, "admin", "123456"));
    }

    public User findByUsername(String username) {
        return userByUsernameIndex.get(username);
    }

    public User findById(long id) {
        return userById.get(id);
    }

    public void save(User user) {
        if (user.getId() <= 0) {
            user.setId(idGenerator.incrementAndGet());
        }
        userById.put(user.getId(), user);
        userByUsernameIndex.put(user.getUsername(), user);
    }
}
