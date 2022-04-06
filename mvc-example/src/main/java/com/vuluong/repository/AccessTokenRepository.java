package com.vuluong.repository;

import com.vuluong.entity.AccessToken;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AccessTokenRepository {

    private final Map<Long, AccessToken> accessTokenById = new ConcurrentHashMap<>();
    private final Map<Long, AccessToken> accessTokenByUserIdIndex = new ConcurrentHashMap<>();
    private AtomicLong idGenerator = new AtomicLong();

    public void save(AccessToken accessToken) {
        if (accessToken.getId() <= 0) {
            accessToken.setId(idGenerator.incrementAndGet());
        }
        accessTokenById.put(accessToken.getId(), accessToken);
        accessTokenByUserIdIndex.put(accessToken.getUserId(), accessToken);
    }

    public AccessToken findByUserId(long userId) {
        return accessTokenByUserIdIndex.get(userId);
    }
}
