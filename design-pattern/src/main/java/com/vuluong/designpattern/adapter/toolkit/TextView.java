package com.vuluong.designpattern.adapter.toolkit;

import com.vuluong.designpattern.adapter.Pair;

public interface TextView {
    Pair<Double, Double> getOrigin();
    Pair<Double, Double> getExtent();
    boolean isEmpty();
}
