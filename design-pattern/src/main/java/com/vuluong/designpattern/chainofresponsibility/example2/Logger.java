package com.vuluong.designpattern.chainofresponsibility.example2;

import java.util.List;

public class Logger {

    private final List<LoggerAppender> appenders;

    public Logger(List<LoggerAppender> appenders) {
        this.appenders = appenders;
    }

    public void info(String message) {
        for (LoggerAppender appender : appenders) {
            appender.append(message);
        }
    }
}
