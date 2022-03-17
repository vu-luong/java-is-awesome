package com.vuluong.concurrency.phaser;

import java.util.List;
import java.util.concurrent.Phaser;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhaserExample {
    
    private static final int NUM_ITERATIONS = 10;
    private static final int NUM_TASKS = 10;
    
    public static void main(String[] args) {
        System.out.println("Starting PhaserExample test");
        
        // Showcase a one-shot Phaser that starts running
        // a gorup of tasks simultaneously
        runOneShotTasks(makeTasks());
    
        // Showcase a cyclic Phaser that repeatedly
        // performs actions for a given number of iterations.
        runCyclicTasks(makeTasks(), NUM_ITERATIONS);
        
        System.out.println("Finish PhaserExample test");
    }
    
    private static void runOneShotTasks(List<MyTask> tasks) {
        System.out.println("Entering runOneShotTasks()");
        
        // Create a phaser that plays the role of an entry barrier
        // and is initialized with a value of 1 to register itself.
        Phaser entryPhaser = new Phaser(1);
        
        // Create a phaser that plays the role of an exit barrier
        // and is initialized with the number of tasks to complete.
        // This usage pattern of Phaser is similar to a CountDownLatch.
        Phaser exitPhaser = new Phaser(tasks.size());
        
        tasks.forEach(task -> {
            entryPhaser.register();
            
            new Thread(() -> {
                // Await start of all the threads
                int phaseNumber = entryPhaser.arriveAndAwaitAdvance();
                task.setPhaseNumber(phaseNumber);
                task.run();
                
                // Indicate that the thread has arrived at the
                // exit barrier and is terminating, which acts
                // like CountDownLatch.countDown().
                exitPhaser.arrive();
            }).start();
        });
        
        // Allow calling thread to continue and deregister self so
        // threads can run
        entryPhaser.arriveAndDeregister();
        
        // Block on the exit barrier until all the threads exit.
        exitPhaser.awaitAdvance(0);
        
        System.out.println("Leaving runOneShotTasks()");
    }
    
    /**
     * @return A List of MyTask objects
     */
    private static List<MyTask> makeTasks() {
        return IntStream.rangeClosed(1, NUM_TASKS)
            .mapToObj(MyTask::new)
            .collect(Collectors.toList());
    }
    
    /**
     * A test that showcases a cyclic Phaser that repeatedly performs actions on the List of {@code
     * tasks} for a given number of {@code iterations}
     */
    private static void runCyclicTasks(List<MyTask> tasks, int iterations) {
        System.out.println("Entering runCyclicTasks()");
        
        Phaser phaser = new Phaser() {
            /**
             * Hook method that decides whether to terminate the phaser or not
             */
            @Override
            protected boolean onAdvance(int phase, int regParties) {
                // Terminate phaser when we've reached the number of
                // iterations or there are no more parties registered.
                return (phase + 1) == iterations || regParties == 0;
            }
        };
        
        // Register the calling thread (to defer worker threads
        // advancing to next phase until the end of this method) and
        // all of the tasks (so we don't need to do this within the
        // forEach() loop below).
        phaser.bulkRegister(1 + tasks.size());
        
        tasks.forEach(task -> {
            new Thread(() -> {
                do {
                    task.run();
                    
                    // Await phase completion of all other
                    // tasks/threads
                    int phaseNumber = phaser.arriveAndAwaitAdvance();
                    
                    // Set phase number (used for diagnostics).
                    task.setPhaseNumber(phaseNumber);
                } while (!phaser.isTerminated());
            }).start();
        });
        
        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }
        
        System.out.println("Leaving runCyclicTasks");
    }
}
