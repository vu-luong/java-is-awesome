package com.vuluong.designpattern.bridge;

import com.vuluong.designpattern.common.Point;
import com.vuluong.designpattern.bridge.window.ApplicationWindow;
import com.vuluong.designpattern.bridge.window.IconWindow;
import com.vuluong.designpattern.bridge.window.Window;
import com.vuluong.designpattern.bridge.windowimp.PMWindowImp;
import com.vuluong.designpattern.bridge.windowimp.WindowImp;
import com.vuluong.designpattern.bridge.windowimp.XWindowImp;

/**
 * Reference: GoF page 151 - Bridge design pattern
 */

public class Main {
    
    public static void main(String[] args) {
        WindowImp windowImp = new XWindowImp();
        View view = new View();
        
        Window window = new ApplicationWindow(windowImp, view);
        window.drawContents();
        window.drawRect(Point.of(1D, 1D), Point.of(2D, 2D));
        
        // switch imp at run time
        window.setWindowImp(new PMWindowImp());
        window.drawContents();
        window.drawRect(Point.of(1D, 1D), Point.of(2D, 2D));
        
        // switch window at run time
        window = new IconWindow(windowImp, view, "bitmap name");
        window.drawContents();
        window.drawRect(Point.of(1D, 1D), Point.of(2D, 2D));
    }
}
