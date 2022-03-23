package com.vuluong.designpattern.factorymethod;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PolygonFactory {

    private final Map<Integer, Supplier<Polygon>> polygonSupplierByNumberOfSides = new HashMap<>();

    public PolygonFactory() {
        polygonSupplierByNumberOfSides.put(3, Triangle::new);
        polygonSupplierByNumberOfSides.put(4, Square::new);
        polygonSupplierByNumberOfSides.put(5, Pentagon::new);
        polygonSupplierByNumberOfSides.put(7, Heptagon::new);
        polygonSupplierByNumberOfSides.put(8, Octagon::new);
    }

    public Polygon getPolygon(int numberOfSides) {
        Supplier<Polygon> supplier = polygonSupplierByNumberOfSides.get(numberOfSides);
        if (supplier == null) {
            throw new IllegalArgumentException("Shape not found for " + numberOfSides + " sides");
        }
        return supplier.get();
    }
}
