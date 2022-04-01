package com.vuluong.concurrency.deadlock;

public class DeadlockExample {

    public static void main(String[] args) {
        final Friend foo = new Friend("Foo");
        final Friend bar = new Friend("Bar");

        new Thread(() -> foo.bow(bar)).start();
        new Thread(() -> bar.bow(foo)).start();
    }
}
