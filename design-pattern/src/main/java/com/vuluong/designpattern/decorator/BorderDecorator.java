package com.vuluong.designpattern.decorator;

public class BorderDecorator extends Decorator {

    private int width;

    public BorderDecorator(VisualComponent component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        drawBorder(width);
    }

    private void drawBorder(int width) {
        System.out.println("draw border; width = " + width);
    }
}
