package com.vuluong.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeEquipment implements Equipment {
    private final List<Equipment> equipments = new ArrayList<>();
    
    @Override
    public double getPrice() {
        Iterator<Equipment> iter = createIterator();
        double total = 0;
        while (iter.hasNext()) {
            Equipment equipment = iter.next();
            total += equipment.getPrice();
        }
        return total;
    }

    @Override
    public void add(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void remove(Equipment equipment) {
        equipments.remove(equipment);
    }

    @Override
    public Iterator<Equipment> createIterator() {
        return equipments.iterator();
    }
}
