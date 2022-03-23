package com.vuluong.designpattern.interpreter;

public class Row {

    private String name;
    private String surname;

    public Row(String name, String surname) {
        this.name    = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
