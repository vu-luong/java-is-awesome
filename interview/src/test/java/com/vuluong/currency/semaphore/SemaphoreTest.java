package com.vuluong.currency.semaphore;


import com.vuluong.concurrency.semaphore.LoginQueueUsingSemaphore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SemaphoreTest {
    
    @Test
    public void exceedLimitTest() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
            .forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();
        
        assertEquals(0, loginQueue.availableSlots());
        assertFalse(loginQueue.tryLogin());
    }
    
    @Test
    public void logoutTest() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
            .forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();
        assertEquals(0, loginQueue.availableSlots());
        loginQueue.logout();
        
        assertTrue(loginQueue.availableSlots() > 0);
        assertTrue(loginQueue.tryLogin());
    }
}
