package com.vuluong.designpattern.bridge;

public class BridgeExample {

    public static void main(String[] args) {
        String databaseType = args.length > 0 ? args[0] : "MySQL";

        // create persistence API
        Persistence persistenceAPI = new PersistenceImpl(databaseType);

        // save an entity
        persistenceAPI.persist(new UserEntity("foo", "foo1234"));

        // get an entity
        UserEntity user = (UserEntity) persistenceAPI.findById("foo");
        System.out.println("findById(foo) = " + user);

        // delete an entity
        persistenceAPI.deleteByid("1234");
    }
}
