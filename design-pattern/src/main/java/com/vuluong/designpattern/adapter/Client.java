package com.vuluong.designpattern.adapter;

import com.vuluong.designpattern.adapter.toolkit.TextView;
import com.vuluong.designpattern.adapter.toolkit.TextViewImpl;
import com.vuluong.designpattern.common.Point;

public class Client {
    
    public void accept(Shape shape) {
        Pair<Point, Point> boundingBox = shape.getBoundingBox();
        System.out.println("bottom left: " + boundingBox.getFirst().toString());
        System.out.println("top right: " + boundingBox.getSecond().toString());
    }

    public static void main(String[] args) {
        Client client = new Client();

        // adaptee
        TextView textView = new TextViewImpl();
        
        // client.accept(textView); // incompatible interface
        
        // adapter
        Shape textShape = new TextShape(textView);
        
        client.accept(textShape);
    }
}
