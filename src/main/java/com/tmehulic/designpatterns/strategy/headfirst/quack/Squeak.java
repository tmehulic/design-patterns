package com.tmehulic.designpatterns.strategy.headfirst.quack;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
