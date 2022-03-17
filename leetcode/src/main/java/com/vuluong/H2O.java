package com.vuluong;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

class H2O {
    Semaphore hydrogenSemaphore = new Semaphore(2);
    Semaphore oxygenSemaphore = new Semaphore(1);
    Phaser phaser = new Phaser(3);
    
    public H2O() {}
    
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        phaser.arriveAndAwaitAdvance();
        hydrogenSemaphore.release();
    }
    
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        phaser.arriveAndAwaitAdvance();
        oxygenSemaphore.release();
    }
}
