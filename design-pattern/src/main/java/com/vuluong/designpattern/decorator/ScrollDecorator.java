package com.vuluong.designpattern.decorator;

public class ScrollDecorator extends Decorator {

    public ScrollDecorator(VisualComponent component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        drawScroll();
    }

    private void drawScroll() {
        System.out.println("draw scroll");
    }
}
