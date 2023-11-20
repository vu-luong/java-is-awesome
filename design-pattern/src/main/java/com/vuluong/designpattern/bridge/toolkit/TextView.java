package com.vuluong.designpattern.bridge.toolkit;

import com.vuluong.designpattern.bridge.Pair;

public interface TextView {
    Pair<Double, Double> getOrigin();
    Pair<Double, Double> getExtent();
    boolean isEmpty();
}
