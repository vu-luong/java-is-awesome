package com.vuluong.designpattern.chainofresponsibility.example2;

public class ConsoleAppender implements LoggerAppender {

    @Override
    public void append(String message) {
        System.out.println("Console: " + message);
    }
}
