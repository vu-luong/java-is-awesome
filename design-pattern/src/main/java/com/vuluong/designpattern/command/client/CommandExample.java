package com.vuluong.designpattern.command.client;

import com.vuluong.designpattern.command.command.OpenTextFileOperation;
import com.vuluong.designpattern.command.command.SaveTextFileOperation;
import com.vuluong.designpattern.command.command.TextFileOperation;
import com.vuluong.designpattern.command.invoker.TextFileOperationExecutor;
import com.vuluong.designpattern.command.receiver.TextFile;

public class CommandExample {

    public static void main(String[] args) {
        TextFileOperation openTextFileOperation
            = new OpenTextFileOperation(new TextFile("file1.txt"));
        TextFileOperation saveTextFileOperation
            = new SaveTextFileOperation(new TextFile("file2.txt"));

        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

        System.out.println(textFileOperationExecutor.executeOperation(openTextFileOperation));
        System.out.println(textFileOperationExecutor.executeOperation(saveTextFileOperation));

        System.out.println(
            textFileOperationExecutor.executeOperation(() -> new TextFile("file3.txt").open())
        );

        System.out.println(
            textFileOperationExecutor.executeOperation(() -> new TextFile("file4.txt").save())
        );
        System.out.println(textFileOperationExecutor.getTextFileOperations());
    }
}
