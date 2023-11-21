package com.vuluong.designpattern.adapter.manipulator;

import com.vuluong.designpattern.adapter.Shape;

public class TextManipulator implements Manipulator {

    private Shape shape;
    
    public TextManipulator(Shape shape) {
        this.shape = shape;
    }
}
