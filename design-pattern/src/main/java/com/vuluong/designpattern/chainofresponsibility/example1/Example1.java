package com.vuluong.designpattern.chainofresponsibility.example1;

import static com.vuluong.designpattern.chainofresponsibility.example1.Logger.*;

public class Example1 {

    public static void main(String[] args) {
        // Build an immutable chain of responsibility
        Logger logger = consoleLogger(LogLevel.all())
            .appendNext(emailLogger(LogLevel.FUNCTIONAL_MESSAGE, LogLevel.FUNCTIONAL_ERROR))
            .appendNext(fileLogger(LogLevel.WARNING, LogLevel.ERROR));

        // Handled by consoleLogger since the console has a LogLevel of all
        logger.message("Entering function ProcessOrder().", LogLevel.DEBUG);
        logger.message("Order record retrieved.", LogLevel.INFO);

        // Handled by consoleLogger and emailLogger
        logger.message("Unable to Process Order ORDER1", LogLevel.FUNCTIONAL_ERROR);
        logger.message("Order Dispatched.", LogLevel.FUNCTIONAL_MESSAGE);

        // Handled by consoleLogger and fileLogger
        logger.message("Customer Address details missing in Branch Database.", LogLevel.WARNING);
        logger.message("Customer Address details missing in Organization Database", LogLevel.WARNING);
    }
}
