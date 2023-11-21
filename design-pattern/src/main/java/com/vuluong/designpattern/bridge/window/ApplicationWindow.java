package com.vuluong.designpattern.bridge.window;

import com.vuluong.designpattern.bridge.View;
import com.vuluong.designpattern.bridge.windowimp.WindowImp;

public class ApplicationWindow extends Window {

    public ApplicationWindow(
        WindowImp windowImp,
        View view
    ) {
        super(windowImp, view);
    }

    @Override
    public void drawContents() {
        getView().drawOn(this);
    }

    @Override
    public String toString() {
        return "Application window";
    }
}
