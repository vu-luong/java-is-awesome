package com.vuluong.designpattern.adapter;

import com.vuluong.designpattern.adapter.manipulator.Manipulator;
import com.vuluong.designpattern.common.Point;

public interface Shape {
    Pair<Point, Point> getBoundingBox();
    Manipulator createManipulator();
}
