package com.vuluong.concurrency.atomic;

public class VolatileVisibilityExample {
	private boolean active;
	
	public void prepare() throws InterruptedException {
		new Thread(() -> {
			System.out.println("Application preparing...");
			sleep(3);
			active = true;
		}).start();
	}
	
	public void start() throws Exception {
		new Thread(() -> {
			while (!active) {}
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
		VolatileVisibilityExample example = new VolatileVisibilityExample();
		example.prepare();
		example.start();
		sleep(10);
	}
	
}
