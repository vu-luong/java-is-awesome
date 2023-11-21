package com.vuluong.designpattern.adapter.toolkit;

import com.vuluong.designpattern.adapter.Pair;

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
