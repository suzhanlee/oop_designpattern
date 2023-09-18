package com.oop.sync;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class VolatileTestTest {

    private volatile static boolean flag = false;
    private long count = 0; // volatile 키워드 추가

    @Test
    @DisplayName("가시성 문제가 발생하지 않습니다.")
    void test() throws InterruptedException {

        threadTest();
        assertTimeoutPreemptively(Duration.ofMillis(4008), this::threadTest);
    }

    private void threadTest() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (!flag) {
                i++;
            }
        });

        thread1.start();
        thread1.sleep(4000);
        flag = true;
        System.out.println(1);
        long time = System.currentTimeMillis() - startTime;
//        System.out.println(time);
    }

    @Test
    @RepeatedTest(100)
    void threadNotSafe() throws Exception {

        int maxCnt = 1000;

        for (int i = 0; i < maxCnt; i++) {
            new Thread(() -> count++).start();
        }

        Thread.sleep(100);
        assertEquals(maxCnt, count);
    }
}