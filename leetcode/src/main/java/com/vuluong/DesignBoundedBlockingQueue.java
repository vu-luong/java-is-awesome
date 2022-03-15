package com.vuluong;

import java.util.LinkedList;
import java.util.Queue;

public class DesignBoundedBlockingQueue {
    private static class BoundedBlockingQueue {
        private final Queue<Integer> queue = new LinkedList<>();
        private final int capacity;
        
        public BoundedBlockingQueue(int capacity) {
            this.capacity = capacity;
        }
        
        public void enqueue(int element) throws InterruptedException {
            synchronized (queue) {
                while (this.size() >= this.capacity) {
                    queue.wait();
                }
                queue.offer(element);
                queue.notifyAll();
            }
        }
        
        public int dequeue() throws InterruptedException {
            synchronized (queue) {
                while (this.size() == 0) {
                    queue.wait();
                }
                int answer = queue.poll();
                queue.notifyAll();
                return answer;
            }
        }
        
        public int size() {
            return this.queue.size();
        }
    }
    
    public static void main(String[] args) {
    
    }
}
