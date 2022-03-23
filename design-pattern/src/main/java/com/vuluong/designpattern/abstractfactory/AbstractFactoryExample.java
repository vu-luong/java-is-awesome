package com.vuluong.designpattern.abstractfactory;

public class AbstractFactoryExample {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        AbstractFactory abstractFactory;

        abstractFactory = FactoryProvider.getFactory("Animal");
        Animal animal = (Animal) abstractFactory.create("Dog");

        abstractFactory = FactoryProvider.getFactory("Color");
        Color color = (Color) abstractFactory.create("Brown");

        String result = "A " + animal.getAnimal() + " with " + color.getColor() + " color "
            + animal.makeSound();

        System.out.println(result);
    }
}
