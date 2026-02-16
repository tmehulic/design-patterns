package com.tmehulic.designpatterns.strategy.headfirst.fly;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!!");
    }
}
