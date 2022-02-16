package com.vuluong.designpattern.factorymethod;

public class MagicRoom implements Room {
    @Override
    public void connect(Room room) {}
    
    @Override
    public String toString() {
        return "Magic Room " + Integer.toHexString(this.hashCode());
    }
}
