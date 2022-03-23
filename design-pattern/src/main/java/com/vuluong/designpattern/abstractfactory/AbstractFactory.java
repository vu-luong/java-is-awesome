package com.vuluong.designpattern.abstractfactory;

public interface AbstractFactory<T> {
    T create(String type);
}
