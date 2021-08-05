package com.vuluong.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicVisibilityExample {
	private AtomicBoolean active = new AtomicBoolean(false);
	
	public void prepare() throws InterruptedException {
		new Thread(() -> {
			System.out.println("Application preparing...");
			sleep(3);
			active.set(true);
		}).start();
	}
	
	public void start() throws Exception {
		new Thread(() -> {
			while (!active.get()) {
			}
			System.out.println("Application started");
		}).start();
	}
	
	private static void sleep(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		AtomicVisibilityExample example = new AtomicVisibilityExample();
		example.prepare();
		example.start();
		sleep(10);
	}
}
