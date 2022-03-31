package com.vuluong.designpattern.visitor;

import java.util.UUID;

public class VisitorExample {

    public static void main(String[] args) {
        Visitor v = new ElementVisitor();

        Document d = new Document(generateUuid());
        d.addElement(new JsonElement(generateUuid()));
        d.addElement(new JsonElement(generateUuid()));
        d.addElement(new XmlElement(generateUuid()));

        d.accept(v);
    }

    private static String generateUuid() {
        return UUID.randomUUID()
            .toString();
    }
}
