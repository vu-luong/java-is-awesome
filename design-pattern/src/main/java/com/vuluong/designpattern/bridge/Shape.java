package com.vuluong.designpattern.bridge;

import com.vuluong.designpattern.bridge.manipulator.Manipulator;

public interface Shape {
    Pair<Point, Point> getBoundingBox();
    Manipulator createManipulator();
}
