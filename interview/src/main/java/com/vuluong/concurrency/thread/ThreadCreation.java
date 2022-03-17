package com.vuluong.concurrency.thread;

public class ThreadCreation {

    public void createThread1() {
        Thread thread = new Thread(
            () -> System.out.println("Hello World from runnable!")
        );
        thread.start();
    }

    public void createThread2() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello World from subclass!");
            }
        };
        thread.start();
    }

    public static void main(String[] args) {
        ThreadCreation threadCreation = new ThreadCreation();
        threadCreation.createThread1();
        threadCreation.createThread2();
    }

}
