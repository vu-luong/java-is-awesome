package com.vuluong.concurrency.atomic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSynchronizeExample {
	
	private AtomicInteger count = new AtomicInteger(0);
	private final Map map = new ConcurrentHashMap();
	
	public void start() {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				int value;
				while ((value = count.incrementAndGet()) <= 1000000) {
					map.put(Integer.valueOf(value), Integer.valueOf(value));
				}
			});
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
	
	public static void main(String[] args) throws Exception {
		AtomicSynchronizeExample example = new AtomicSynchronizeExample();
		example.start();
		Thread.sleep(3000);
		System.out.println(example.map.size());
	}
	
}
