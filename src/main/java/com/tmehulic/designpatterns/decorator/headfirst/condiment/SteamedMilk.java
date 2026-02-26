package com.tmehulic.designpatterns.decorator.headfirst.condiment;

import com.tmehulic.designpatterns.decorator.headfirst.beverage.Beverage;

public class SteamedMilk extends CondimentDecorator {

    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
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
