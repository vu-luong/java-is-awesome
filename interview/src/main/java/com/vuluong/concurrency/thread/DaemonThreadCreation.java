package com.vuluong.concurrency;

public class DaemonThreadCreation {

    public void createNormalThread() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(400L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello World from normal thread");
        });
        thread.start();
    }

    public void createDaemonThread() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello World from daemon thread!");
        }
        );
        thread.setDaemon(true);
        thread.start();
    }

    // Daemon thread does not prevent JVM from exiting
    // --> all daemon threads are abandoned when all non-daemon threads are terminated
    public static void main(String[] args) {
        DaemonThreadCreation creator = new DaemonThreadCreation();
        // The daemon thread is being abandoned before printing text
        creator.createDaemonThread();

        // The normal thread keeps JVM running
        creator.createNormalThread();
    }
}
