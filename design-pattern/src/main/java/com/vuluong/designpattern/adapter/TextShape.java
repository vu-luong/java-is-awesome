package com.vuluong.designpattern.adapter;

import com.vuluong.designpattern.adapter.manipulator.Manipulator;
import com.vuluong.designpattern.adapter.manipulator.TextManipulator;
import com.vuluong.designpattern.adapter.toolkit.TextView;
import com.vuluong.designpattern.common.Point;

public class TextShape implements Shape {

    private TextView textView;

    public TextShape(TextView textView) {
        this.textView = textView;
    }

    @Override
    public Pair<Point, Point> getBoundingBox() {
        Pair<Double, Double> origin = textView.getOrigin();
        Pair<Double, Double> extent = textView.getExtent();

        double bottom = origin.getFirst();
        double left = origin.getSecond();
        double width = extent.getFirst();
        double height = extent.getSecond();

        Point bottomLeft = new Point(bottom, left);
        Point topRight = new Point(bottom + height, left + width);
        return Pair.of(bottomLeft, topRight);
    }

    @Override
    public Manipulator createManipulator() {
        return new TextManipulator(this);
    }
}
