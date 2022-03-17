package com.vuluong.concurrency.blockingqueue;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {
    private List<T> queue = new LinkedList<>();

    private int limit = 10;

    public synchronized void put(T item) {
        while (queue.size() == limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (queue.isEmpty()) {
            notifyAll();
        }

        queue.add(item);
    }

    public synchronized T take() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (queue.size() == limit) {
            notifyAll();
        }
        return queue.remove(0);
    }

    @Override
    public String toString() {
        return "BlockingQueue{" +
                   "queue=" + queue +
                   '}';
    }
}
