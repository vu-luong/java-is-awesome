package com.vuluong.designpattern.composite;

public class Application {

    public static void main(String[] args) {
        Equipment cabinet = new Cabinet();
        Equipment chassis = new Chassis();
        
        cabinet.add(chassis);
        
        Equipment bus = new Bus();
        bus.add(new Card());
        
        chassis.add(bus);
        chassis.add(new FloppyDisk());
        
        System.out.println(chassis.getPrice());
    }
}
