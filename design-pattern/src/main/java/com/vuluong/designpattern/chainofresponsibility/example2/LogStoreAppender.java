package com.vuluong.designpattern.chainofresponsibility.example2;

public class LogStoreAppender implements LoggerAppender {

    @Override
    public void append(String message) {
        System.out.println("LogStore: " + message);
    }
}
