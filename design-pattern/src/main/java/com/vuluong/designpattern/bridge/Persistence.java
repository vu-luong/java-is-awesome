package com.vuluong.designpattern.bridge;

public interface Persistence {
    
    public void persist(Entity entity);
    public Entity findById(String id);
    public void deleteByid(String id);
}
