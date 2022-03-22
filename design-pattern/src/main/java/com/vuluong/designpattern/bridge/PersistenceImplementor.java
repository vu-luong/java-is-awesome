package com.vuluong.designpattern.bridge;

// bridge interface
public interface PersistenceImplementor {
    
    public void saveEntity(Entity entity);
    public void deleteEntity(String entityId);
    public Entity getEntity(String entityId);
}
