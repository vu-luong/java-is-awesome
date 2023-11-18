package com.vuluong.designpattern.builder.hierarchies;

import java.util.EnumSet;
import java.util.Set;

// Builder pattern for class hierarchies
// Root of a hierarchy representing various kinds of pizza
public abstract class Pizza {
    public enum Topping {
        HAM,
        MUSHROOM,
        ONION,
        PEPPER,
        SAUSAGE
    }

    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    abstract static class Builder<B extends Builder<B>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public B addTopping(Topping topping) {
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        protected abstract B self();
    }
}
