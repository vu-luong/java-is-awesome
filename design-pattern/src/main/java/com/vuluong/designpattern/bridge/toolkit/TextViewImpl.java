package com.vuluong.designpattern.bridge.toolkit;

import com.vuluong.designpattern.bridge.Pair;

public class TextViewImpl implements TextView {
    
    @Override
    public Pair<Double, Double> getOrigin() {
        return Pair.of(0D, 0D);
    }

    @Override
    public Pair<Double, Double> getExtent() {
        return Pair.of(10D, 10D);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
