package com.tmehulic.designpatterns.decorator.headfirst.condiment;

import com.tmehulic.designpatterns.decorator.headfirst.beverage.Beverage;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return switch (beverage.getSize()) {
            case TALL -> beverage.cost() + .20;
            case GRANDE -> beverage.cost() + .25;
            case VENTI -> beverage.cost() + .30;
        };
    }
}
