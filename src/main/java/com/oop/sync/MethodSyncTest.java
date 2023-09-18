package com.oop.sync;

import java.util.ArrayList;
import java.util.List;

public class MethodSyncTest {

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {

        MethodSyncTest mSyncTest = new MethodSyncTest();

        System.out.println("mSyncTest start");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                mSyncTest.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                mSyncTest.add(i);
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

        System.out.println("mSyncTest end");

        System.out.println("list1 size : " + mSyncTest.list1.size()); // 항상 100
        System.out.println("list2 size : " + mSyncTest.list2.size()); // 종종 100 이 넘는다.
    }

    public void add(int value) {

        /*
          code that Sync is not needed
         */
        if (!list2.contains(value)) {
            list2.add(value);
        }

        synchronized (this) {
            if (!list1.contains(value)) {
                list1.add(value);
            }
        }
    }

}
