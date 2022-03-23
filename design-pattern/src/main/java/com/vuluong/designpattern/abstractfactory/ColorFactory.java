package com.vuluong.designpattern.abstractfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ColorFactory implements AbstractFactory<Color> {
    private final Map<String, Supplier<Color>> colorSupplierByType = new HashMap<>();

    public ColorFactory() {
        colorSupplierByType.put("Brown", Brown::new);
        colorSupplierByType.put("White", White::new);
    }

    @Override
    public Color create(String type) {
        Supplier<Color> supplier = colorSupplierByType.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException("Color not found for type: " + type);
        }
        return supplier.get();
    }
}
