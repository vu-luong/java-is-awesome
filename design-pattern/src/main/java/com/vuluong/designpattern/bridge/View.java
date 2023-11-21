package com.vuluong.designpattern.bridge;

import com.vuluong.designpattern.bridge.window.Window;

public class View {

    public void drawOn(Window window) {
        System.out.println("View drawOn: " + window);
    }
}
