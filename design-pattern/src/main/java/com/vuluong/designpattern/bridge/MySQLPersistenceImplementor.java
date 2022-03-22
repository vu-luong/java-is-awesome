package com.vuluong.designpattern.bridge;

import java.util.HashMap;
import java.util.Map;

public class MySQLPersistenceImplementor implements PersistenceImplementor {
    
    private final Map<String, Entity> entities = new HashMap<>();
    
    @Override
    public void saveEntity(Entity entity) {
        entities.put(entity.getId(), entity);
    }
    
    @Override
    public void deleteEntity(String entityId) {
        entities.remove(entityId);
    }
    
    @Override
    public Entity getEntity(String entityId) {
        return entities.get(entityId);
    }
}
