package com.tmehulic.designpatterns.decorator.headfirst.condiment;

import com.tmehulic.designpatterns.decorator.headfirst.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;

    public abstract String getDescription();
}
