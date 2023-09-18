package com.oop.sync;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class VolatileTest {
    private volatile long count = 0;

    @Test
    @RepeatedTest(10)
    @DisplayName("volatile을 사용하면 thread-safe하다")
    void volatileTest() throws Exception {

        int maxCnt = 1000;

        for (int i = 0; i < maxCnt; i++) {
            new Thread(() -> count++).start();
        }

        Thread.sleep(100);
        assertEquals(maxCnt, count);
    }
}