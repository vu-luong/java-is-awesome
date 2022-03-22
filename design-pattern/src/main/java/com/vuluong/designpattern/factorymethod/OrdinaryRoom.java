package com.vuluong.designpattern.factorymethod;

public class OrdinaryRoom implements Room {
    @Override
    public void connect(Room room) {}
    
    @Override
    public String toString() {
        return "Ordinary Room " + Integer.toHexString(this.hashCode());
    }
}
