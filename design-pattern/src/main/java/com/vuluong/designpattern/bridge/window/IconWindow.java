package com.vuluong.designpattern.bridge.window;

import com.vuluong.designpattern.bridge.View;
import com.vuluong.designpattern.bridge.windowimp.WindowImp;

public class IconWindow extends Window {
    private final String bitmapName;

    public IconWindow(WindowImp windowImp, View view, String bitmapName) {
        super(windowImp, view);
        this.bitmapName = bitmapName;
    }

    @Override
    public void drawContents() {
        WindowImp imp = getWindowImp();
        if (imp != null) {
            imp.deviceBitmap(bitmapName, 0, 0);
        }
    }

    @Override
    public String toString() {
        return "Icon window";
    }
}
