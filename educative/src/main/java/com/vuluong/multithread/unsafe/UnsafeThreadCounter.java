package com.vuluong.multithread.unsafe;

public class UnsafeThreadCounter {
    
    int count = 0;
    
    public void increment() {
        count++;
    }
    
    public void decrement() {
        count--;
    }
    
    void printFinalCounterValue() {
        System.out.println("Counter is: " + count);
    }
}
