package com.vuluong.designpattern.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<U, V> {
    private U first;
    private V second;
    
    public static <U, V> Pair<U, V> of(U first, V second) {
        return new Pair<>(first, second);
    }
}
