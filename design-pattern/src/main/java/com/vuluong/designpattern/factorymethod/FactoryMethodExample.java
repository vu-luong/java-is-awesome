package com.vuluong.designpattern.factorymethod;

public class FactoryMethodExample {

    public static void main(String[] args) {
        PolygonFactory factory = new PolygonFactory();

        Polygon p1 = factory.getPolygon(4);
        System.out.println("The shape with 4 sides is a " + p1.getType());

        Polygon p2 = factory.getPolygon(7);
        System.out.println("The shape with 7 sides is a " + p2.getType());

        // exception case
        Polygon p3 = factory.getPolygon(6);
        System.out.println("The shape with 6 sides is a " + p3.getType());
    }
}
