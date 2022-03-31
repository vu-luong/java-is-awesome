package com.vuluong.designpattern.visitor;

public class JsonElement extends Element {

    public JsonElement(String uuid) {
        super(uuid);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
