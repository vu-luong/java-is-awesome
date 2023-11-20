package com.vuluong.designpattern.bridge.manipulator;

import com.vuluong.designpattern.bridge.Shape;

public class TextManipulator implements Manipulator {

    private Shape shape;
    
    public TextManipulator(Shape shape) {
        this.shape = shape;
    }
}
