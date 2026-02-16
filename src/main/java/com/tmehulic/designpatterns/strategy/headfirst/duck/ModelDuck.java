package com.tmehulic.designpatterns.strategy.headfirst.duck;

import com.tmehulic.designpatterns.strategy.headfirst.fly.FlyNoWay;
import com.tmehulic.designpatterns.strategy.headfirst.quack.MuteQuack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck!");
    }
}
