package com.vuluong.designpattern.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {
    private double x, y;

    public static Point of(double x, double y) {
        return new Point(x, y);
    }
}
