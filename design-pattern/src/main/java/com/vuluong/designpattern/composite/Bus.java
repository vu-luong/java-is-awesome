package com.vuluong.designpattern.composite;

public class Bus extends CompositeEquipment {

    @Override
    public double getPrice() {
        return super.getPrice() + 20;
    }
}
