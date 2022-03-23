package com.vuluong.designpattern.abstractfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("rawtypes")
public class FactoryProvider {

    private static final Map<String, Supplier<AbstractFactory>> factorySupplierByChoice
        = new HashMap<>();

    static {
        factorySupplierByChoice.put("Animal", AnimalFactory::new);
        factorySupplierByChoice.put("Color", ColorFactory::new);
    }

    public static AbstractFactory getFactory(String choice) {
        Supplier<AbstractFactory> supplier = factorySupplierByChoice.get(choice);
        if (supplier == null) {
            throw new IllegalArgumentException("Factory not found for choice: " + choice);
        }
        return supplier.get();
    }
}
