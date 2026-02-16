package com.tmehulic.designpatterns.strategy.headfirst.duck;

import com.tmehulic.designpatterns.strategy.headfirst.fly.FlyWithWings;
import com.tmehulic.designpatterns.strategy.headfirst.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck!");
    }
}
