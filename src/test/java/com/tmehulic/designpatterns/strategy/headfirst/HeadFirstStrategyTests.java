package com.tmehulic.designpatterns.strategy.headfirst;

import com.tmehulic.designpatterns.strategy.headfirst.duck.Duck;
import com.tmehulic.designpatterns.strategy.headfirst.duck.MallardDuck;
import com.tmehulic.designpatterns.strategy.headfirst.duck.ModelDuck;
import com.tmehulic.designpatterns.strategy.headfirst.fly.FlyRocketPowered;

import org.junit.jupiter.api.Test;

class HeadFirstStrategyTests {

    @Test
    void testMallardDuck() {
        Duck mallard = new MallardDuck();
        mallard.performQuack(); // Output: Quack!
        mallard.performFly(); // Output: I'm flying!!
    }

    @Test
    void testRocketPowered() {
        Duck model = new ModelDuck();
        model.performFly(); // Output: I can't fly!!

        model.setFlyBehavior(new FlyRocketPowered());

        model.performFly(); // Output: I'm flying with a rocket!!
    }
}
