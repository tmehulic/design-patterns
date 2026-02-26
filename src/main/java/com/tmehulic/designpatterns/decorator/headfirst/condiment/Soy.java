package com.tmehulic.designpatterns.decorator.headfirst.condiment;

import com.tmehulic.designpatterns.decorator.headfirst.beverage.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return switch (beverage.getSize()) {
            case TALL -> beverage.cost() + .15;
            case GRANDE -> beverage.cost() + .20;
            case VENTI -> beverage.cost() + .25;
        };
    }
}
