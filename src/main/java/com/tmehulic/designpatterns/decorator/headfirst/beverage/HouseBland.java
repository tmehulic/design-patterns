package com.tmehulic.designpatterns.decorator.headfirst.beverage;

public class HouseBland extends Beverage {

    public HouseBland() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
