package com.vuluong.designpattern.composite;

import java.util.Iterator;

public interface Equipment {
    
    double getPrice();
    
    void add(Equipment equipment);
    
    void remove(Equipment equipment);
    
    Iterator<Equipment> createIterator();
}
