package com.vuluong.currency.phaser;

import com.vuluong.concurrency.phaser.LongRunningAction;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import static org.junit.Assert.assertEquals;

public class PhaserTest {
    
    @Test
    public void test() {
        // given
        ExecutorService executorService = Executors.newCachedThreadPool();
        Phaser phaser = new Phaser(1);
        assertEquals(0, phaser.getPhase());
        
        // when
        executorService.submit(new LongRunningAction("thread-1", phaser));
        executorService.submit(new LongRunningAction("thread-2", phaser));
        executorService.submit(new LongRunningAction("thread-3", phaser));
        
        // then
        System.out.println("Thread " + Thread.currentThread().getName() + " waiting for others");
        phaser.arriveAndAwaitAdvance();
        System.out.println("Thread " + Thread.currentThread().getName() + " proceeding in phase "
                               + phaser.getPhase());
        
        assertEquals(1, phaser.getPhase());
        
        // and
        executorService.submit(new LongRunningAction("thread-4", phaser));
        executorService.submit(new LongRunningAction("thread-5", phaser));
        
        System.out.println("Thread " + Thread.currentThread().getName() + " waiting for others");
        phaser.arriveAndAwaitAdvance();
        System.out.println(
            "Thread " + Thread.currentThread().getName() + " proceeding in phase "
                + phaser.getPhase());
        
        assertEquals(2, phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}
