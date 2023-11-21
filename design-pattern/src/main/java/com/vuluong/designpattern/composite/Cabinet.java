package com.vuluong.designpattern.composite;

public class Cabinet extends CompositeEquipment {

    @Override
    public double getPrice() {
        return super.getPrice() + 30;
    }
}
