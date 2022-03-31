package com.vuluong.designpattern.visitor;

public class XmlElement extends Element {

    public XmlElement(String uuid) {
        super(uuid);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
