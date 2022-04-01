package com.vuluong.designpattern.chainofresponsibility.example2;

public class SlackAppender implements LoggerAppender {

    @Override
    public void append(String message) {
        System.out.println("Slack: " + message);
    }
}
