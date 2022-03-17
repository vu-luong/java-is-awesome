package com.vuluong;

public class PrintInOrder {
    
    private volatile boolean firstJobDone = false;
    private volatile boolean secondJobDone = false;
    
    public PrintInOrder() {}
    
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone = true;
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        while (!firstJobDone) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone = true;
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        while (!secondJobDone) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
    
}
