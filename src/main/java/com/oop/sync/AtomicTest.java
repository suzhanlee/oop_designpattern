package com.oop.sync;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private volatile long count = 0;

    public static void main(String[] args) throws InterruptedException {

        AtomicTest test = new AtomicTest();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.count++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.count++;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(test.count);
    }
}
