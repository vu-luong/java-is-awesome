package com.vuluong.educative.multithread.sumup;

public class SumUpExample {
    private static final long MAX_NUM = Integer.MAX_VALUE;
    private final long startRange;
    private final long endRange;
    private long counter = 0;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange   = endRange;
    }

    public void add() {
        for (long i = startRange; i <= endRange; ++i) {
            counter += 1;
        }
    }

    private static void runTwoThreads() throws InterruptedException {
        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM / 2);
        SumUpExample s2 = new SumUpExample(MAX_NUM / 2 + 1, MAX_NUM);
        Thread t1 = new Thread(s1::add);
        Thread t2 = new Thread(s2::add);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    private static void runOneThread() {
        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM);
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }

    public static void runTest() throws InterruptedException {
        runOneThread();
        runTwoThreads();
    }
}
