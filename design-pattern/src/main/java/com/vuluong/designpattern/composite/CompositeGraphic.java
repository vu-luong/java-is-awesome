package com.vuluong.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic implements Graphic {
    private List<Graphic> childGraphics = new ArrayList<>();

    public void add(Graphic g) {
        childGraphics.add(g);
    }

    @Override
    public void print() {
        childGraphics.forEach(Graphic::print);
    }
}
