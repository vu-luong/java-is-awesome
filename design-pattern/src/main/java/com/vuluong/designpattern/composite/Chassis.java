package com.vuluong.designpattern.composite;

public class Chassis extends CompositeEquipment {

    @Override
    public double getPrice() {
        return super.getPrice() + 40;
    }
}
