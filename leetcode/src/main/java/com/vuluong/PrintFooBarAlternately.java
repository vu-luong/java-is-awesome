package com.vuluong;

import java.util.concurrent.Semaphore;

class PrintFooBarAlternately {
    private final int n;
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(1);
    
    public PrintFooBarAlternately(int n) {
        this.n = n;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s1.release();
        }
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s2.release();
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        PrintFooBarAlternately problem = new PrintFooBarAlternately(n);
        new Thread(() -> {
            try {
                problem.foo(() -> System.out.print("Foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        new Thread(() -> {
            try {
                problem.bar(() -> System.out.print("Bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
