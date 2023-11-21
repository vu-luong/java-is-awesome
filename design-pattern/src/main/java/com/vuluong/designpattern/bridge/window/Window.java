package com.vuluong.designpattern.bridge.window;

import com.vuluong.designpattern.common.Point;
import com.vuluong.designpattern.bridge.View;
import com.vuluong.designpattern.bridge.windowimp.WindowImp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Window {

    private WindowImp windowImp;
    private View view;

    // requests handled by window
    public abstract void drawContents();

    // requests forwarded to implementation
    public void drawRect(Point first, Point second) {
        WindowImp imp = getWindowImp();
        imp.deviceRect(first.getX(), first.getY(), second.getX(), second.getY());
    }
}
