package com.vuluong.designpattern.bridge;

public class PersistenceImpl implements Persistence {

    // bridge object
    private PersistenceImplementor implementor;

    public PersistenceImpl(String databaseType) {
        this.implementor = databaseType.equals("MySQL")
            ? new MySQLPersistenceImplementor()
            : new OraclePersistenceImplementor();
    }

    @Override
    public void persist(Entity entity) {
        implementor.saveEntity(entity);
    }

    @Override
    public Entity findById(String id) {
        return implementor.getEntity(id);
    }

    @Override
    public void deleteByid(String id) {
        implementor.deleteEntity(id);
    }
}
