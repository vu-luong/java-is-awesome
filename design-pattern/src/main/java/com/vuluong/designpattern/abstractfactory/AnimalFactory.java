package com.vuluong.designpattern.abstractfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AnimalFactory implements AbstractFactory<Animal> {

    private final Map<String, Supplier<Animal>> animalSupplierByType = new HashMap<>();

    public AnimalFactory() {
        animalSupplierByType.put("Dog", Dog::new);
        animalSupplierByType.put("Duck", Duck::new);
    }

    @Override
    public Animal create(String type) {
        Supplier<Animal> supplier = animalSupplierByType.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException("Animal not found for type: " + type);
        }
        return supplier.get();
    }
}
