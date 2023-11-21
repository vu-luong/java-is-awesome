package com.vuluong.designpattern.composite;

import java.util.Iterator;

public class FloppyDisk implements Equipment {
    
    @Override
    public double getPrice() {
        return 10;
    }

    @Override
    public void add(Equipment equipment) {
        throw new IllegalStateException("method not supported");
    }

    @Override
    public void remove(Equipment equipment) {
        throw new IllegalStateException("method not supported");
    }

    @Override
    public Iterator<Equipment> createIterator() {
        throw new IllegalStateException("method not supported");
    }
}
