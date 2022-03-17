package com.vuluong.currency.mutex;

import com.vuluong.concurrency.mutex.CounterUsingMutex;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MutexTest {
    
    @Test
    public void test() throws InterruptedException {
        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        CounterUsingMutex counter = new CounterUsingMutex();
        IntStream.range(0, count)
            .forEach(user -> executorService.execute(() -> {
                try {
                    counter.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        executorService.shutdown();
        assertTrue(counter.hasQueuedThreads());
        
        Thread.sleep(5000);
        assertFalse(counter.hasQueuedThreads());
        assertEquals(count, counter.getCount());
    }
}
