package com.vuluong.multithread.unsafe;

public class UnsafeThreadExample {
    
    public static void main(String[] args) throws InterruptedException {
        UnsafeThreadCounter badCounter = new UnsafeThreadCounter();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500; ++i) {
                badCounter.increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 500; ++i) {
                badCounter.decrement();
            }
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        badCounter.printFinalCounterValue();
    }
}
