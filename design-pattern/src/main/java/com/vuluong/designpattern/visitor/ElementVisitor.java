package com.vuluong.designpattern.visitor;

public class ElementVisitor implements Visitor {

    @Override
    public void visit(XmlElement xe) {
        System.out.println("Processing xml element with uuid: " + xe.getUuid());
    }

    @Override
    public void visit(JsonElement je) {
        System.out.println("Processing json element with uuid: " + je.getUuid());
    }
}
