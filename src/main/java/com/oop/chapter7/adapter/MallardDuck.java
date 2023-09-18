package com.oop.chapter7.adapter;

public class MallardDuck implements Duck {

    @Override
    public void fly() {
        System.out.println("날고 있습니다");
    }

    @Override
    public void quack() {
        System.out.println("꽥");
    }
}
