package com.oop.sync;

import java.util.ArrayList;
import java.util.List;

public class SyncCompareTest {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        SyncCompareTest t1 = new SyncCompareTest();
        SyncCompareTest t2 = new SyncCompareTest();

        System.out.println("syncCompareTest start");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                t1.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                t2.add(i);
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

        System.out.println("syncCompareTest end");

        System.out.println("list1 size : " + list.size());
    }

    public void add(int value) {

        synchronized (SyncCompareTest.class) {
            if (!list.contains(value)) {
                list.add(value);
            }
        }
    }
}
