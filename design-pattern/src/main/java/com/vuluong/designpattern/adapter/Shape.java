package com.vuluong.designpattern.adapter;

import com.vuluong.designpattern.adapter.manipulator.Manipulator;

public interface Shape {
    Pair<Point, Point> getBoundingBox();
    Manipulator createManipulator();
}
