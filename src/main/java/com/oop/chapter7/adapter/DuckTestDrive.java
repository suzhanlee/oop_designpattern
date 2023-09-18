package com.oop.chapter7.adapter;

public class DuckTestDrive {

    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdaptor = new TurkeyAdaptor(turkey);

        testDuck(duck);
        System.out.println("========");
        testDuck(turkeyAdaptor);
    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

}
