package com.vuluong.designpattern.bridge.windowimp;

public class PMWindowImp implements WindowImp {
    
    @Override
    public void deviceRect(double x1, double y1, double x2, double y2) {
        System.out.println(
            "PM Window System - device rect: " + x1 + ", " + x2 + ", " + x2 + ", " + y2
        ); 
    }

    @Override
    public void deviceBitmap(String text, double x, double y) {
        System.out.println(
            "PM Window System - device bitmap: " + text + ", " + x + ", " + y
        );
    }
}
