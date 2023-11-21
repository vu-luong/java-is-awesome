package com.vuluong.designpattern.decorator;

public class TextView implements VisualComponent {
    
    @Override
    public void draw() {
        System.out.println("This is a text view");
    }

    @Override
    public void resize() {
        System.out.println("Text view is resizing");
    }
}
