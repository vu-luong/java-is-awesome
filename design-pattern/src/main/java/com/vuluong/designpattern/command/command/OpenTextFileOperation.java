package com.vuluong.designpattern.command.command;

import com.vuluong.designpattern.command.receiver.TextFile;

public class OpenTextFileOperation implements TextFileOperation {
    private final TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }

    @Override
    public String toString() {
        return "OpenTextFileOperation";
    }
}
