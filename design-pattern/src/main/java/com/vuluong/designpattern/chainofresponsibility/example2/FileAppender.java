package com.vuluong.designpattern.chainofresponsibility.example2;

public class FileAppender implements LoggerAppender {

    @Override
    public void append(String message) {
        System.out.println("File: " + message);
    }
}
