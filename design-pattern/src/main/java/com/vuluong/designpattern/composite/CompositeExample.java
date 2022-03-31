package com.vuluong.designpattern.composite;

public class CompositeExample {

    public static void main(String[] args) {
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();

        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();

        CompositeGraphic compositeGraphic1 = new CompositeGraphic();
        compositeGraphic1.add(ellipse1);
        compositeGraphic1.add(ellipse2);
        compositeGraphic1.add(ellipse3);
        compositeGraphic1.add(rectangle1);

        CompositeGraphic compositeGraphic2 = new CompositeGraphic();
        compositeGraphic2.add(ellipse4);
        compositeGraphic2.add(rectangle2);
        compositeGraphic2.add(rectangle3);

        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(compositeGraphic1);
        compositeGraphic.add(compositeGraphic2);

        compositeGraphic.print();
    }
}
