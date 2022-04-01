package com.vuluong.designpattern.chainofresponsibility.example1;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Consumer;

public interface Logger {
    enum LogLevel {
        INFO, DEBUG, WARNING, ERROR, FUNCTIONAL_MESSAGE, FUNCTIONAL_ERROR;

        public static LogLevel[] all() {
            return values();
        }
    }

    void message(String msg, LogLevel severity);

    default Logger appendNext(Logger nextLogger) {
        return (msg, severity) -> {
            message(msg, severity);
            nextLogger.message(msg, severity);
        };
    }

    static Logger writeLogger(LogLevel[] levels, Consumer<String> stringConsumer) {
        EnumSet<LogLevel> set = EnumSet.copyOf(Arrays.asList(levels));
        return (msg, severity) -> {
            if (set.contains(severity)) {
                stringConsumer.accept(msg);
            }
        };
    }

    static Logger consoleLogger(LogLevel... levels) {
        return writeLogger(levels, msg -> System.err.println("Writing to console: " + msg));
    }

    static Logger emailLogger(LogLevel... levels) {
        return writeLogger(levels, msg -> System.err.println("Sending via email: " + msg));
    }

    static Logger fileLogger(LogLevel... levels) {
        return writeLogger(levels, msg -> System.err.println("writing to Log File: " + msg));
    }
}
