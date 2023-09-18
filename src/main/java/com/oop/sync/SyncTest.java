package com.oop.sync;

import java.util.Objects;

public class SyncTest {

    private String sharedResource;

    public static void main(String[] args) {

        SyncTest syncTest = new SyncTest();

        System.out.println("SyncTest start");

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                syncTest.setSharedResource("resource1");
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                syncTest.setSharedResource("resource2");
            }

        }).start();

        System.out.println("SyncTest end");
    }

    public synchronized void setSharedResource(String resource) {
        sharedResource = resource;

        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!Objects.equals(sharedResource, resource)) {
            System.out.println(sharedResource + " is not same as " + resource);
        }
    }

}
