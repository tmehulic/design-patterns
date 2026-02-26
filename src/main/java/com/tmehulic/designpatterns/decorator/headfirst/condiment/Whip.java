package com.tmehulic.designpatterns.decorator.headfirst.condiment;

import com.tmehulic.designpatterns.decorator.headfirst.beverage.Beverage;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return switch (beverage.getSize()) {
            case TALL -> beverage.cost() + .10;
            case GRANDE -> beverage.cost() + .15;
            case VENTI -> beverage.cost() + .20;
        };
    }
}
