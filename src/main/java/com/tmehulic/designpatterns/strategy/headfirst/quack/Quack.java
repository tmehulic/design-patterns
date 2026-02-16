package com.tmehulic.designpatterns.strategy.headfirst.quack;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
