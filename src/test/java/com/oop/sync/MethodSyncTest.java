package com.oop.sync;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class MethodSyncTest {

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    @Test
    @RepeatedTest(10)
    @DisplayName("synchronized를 사용하면 동시성 이슈가 일어나지 않는다.")
    void test() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                add(i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(10000, list1.size());
        assertNotEquals(10000, list2.size());
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