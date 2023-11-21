package com.vuluong.designpattern.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Decorator implements VisualComponent {

    private final VisualComponent component;

    @Override
    public void draw() {
        component.draw();
    }

    @Override
    public void resize() {
        component.resize();
    }
}
