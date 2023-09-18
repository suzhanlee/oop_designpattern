package com.oop.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

        System.out.println("reentrantLockTest start");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                reentrantLockTest.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                reentrantLockTest.add(i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join(3000);
            thread2.join(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("reentrantLockTest end");

        System.out.println("list1 size : " + reentrantLockTest.list1.size()); // 항상 10000
        System.out.println("list2 size : " + reentrantLockTest.list2.size()); // 종종 10000 이 넘는다.
    }

    public void add(int value) {

        /*
          code that Sync is not needed
         */
        if (!list2.contains(value)) {
            list2.add(value);
        }

        lock.lock();
        if (!list1.contains(value)) {
            list1.add(value);
        }
        lock.unlock();

        /*
          code that Sync is not needed
         */
        if (!list2.contains(value)) {
            list2.add(value);
        }
    }

}
