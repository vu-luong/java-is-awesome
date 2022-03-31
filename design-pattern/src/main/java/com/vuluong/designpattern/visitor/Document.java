package com.vuluong.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Document extends Element {

    private final List<Element> elements = new ArrayList<>();

    public Document(String uuid) {
        super(uuid);
    }

    @Override
    public void accept(Visitor v) {
        for (Element e : this.elements) {
            e.accept(v);
        }
    }

    public void addElement(Element e) {
        this.elements.add(e);
    }
}
