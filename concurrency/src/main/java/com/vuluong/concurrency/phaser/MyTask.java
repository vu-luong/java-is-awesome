package com.vuluong.concurrency.phaser;

import lombok.Setter;

/**
 * A simple class that tracks and print out the task number and phase number.
 */
public class MyTask implements Runnable {
    
    @Setter
    private int phaseNumber;
    private int taskNumber;
    
    public MyTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    
    /**
     * Hook method that runs the task
     */
    @Override
    public void run() {
        System.out.println("Task #" + taskNumber + " has phase #" + phaseNumber + " at "
                               + System.currentTimeMillis());
    }
}
