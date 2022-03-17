package com.vuluong.concurrency;

public class BlockingQueueExample {
    private static final BlockingQueue<Integer> blockingQueue = new BlockingQueue<>();

    public static void createThread1() {
        Thread thread = new Thread(
            () -> {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i <= 20; i++) {
                    System.out.println(i);
                    blockingQueue.put(i);
                }
            }
        );
        thread.start();
    }

    public static void createThread2() {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Take: " + blockingQueue.take());
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        createThread2();
        createThread1();

        System.out.println(blockingQueue);
    }
}
