package com.vuluong.designpattern.command.command;

import com.vuluong.designpattern.command.receiver.TextFile;

public class SaveTextFileOperation implements TextFileOperation {
    private final TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }

    @Override
    public String toString() {
        return "SaveTextFileOperation";
    }
}
