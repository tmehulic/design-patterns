package com.tmehulic.designpatterns.factory.headfirst.pizza;

import com.tmehulic.designpatterns.factory.headfirst.ingredient.Cheese;
import com.tmehulic.designpatterns.factory.headfirst.ingredient.Clams;
import com.tmehulic.designpatterns.factory.headfirst.ingredient.Dough;
import com.tmehulic.designpatterns.factory.headfirst.ingredient.Pepperoni;
import com.tmehulic.designpatterns.factory.headfirst.ingredient.Sauce;
import com.tmehulic.designpatterns.factory.headfirst.ingredient.Veggies;

public abstract class Pizza {

    String name;

    Dough dough;

    Sauce sauce;

    Veggies veggies[];

    Cheese cheese;

    Pepperoni pepperoni;

    Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("Baking pizza...");
    }

    public void cut() {
        System.out.println("Cutting pizza...");
    }

    public void box() {
        System.out.println("Boxing pizza...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
