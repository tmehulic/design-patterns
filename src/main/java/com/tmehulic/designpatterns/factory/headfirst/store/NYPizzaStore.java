package com.tmehulic.designpatterns.factory.headfirst.store;

import com.tmehulic.designpatterns.factory.headfirst.ingredient.NYPizzaIngredientFactory;
import com.tmehulic.designpatterns.factory.headfirst.ingredient.PizzaIngredientFactory;
import com.tmehulic.designpatterns.factory.headfirst.pizza.CheesePizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.ClamPizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.PepperoniPizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.Pizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.VeggiePizza;

public class NYPizzaStore extends PizzaStore {

    PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese" -> {
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("NY Style Sauce and Cheese Pizza");
            }
            case "veggie" -> {
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("NY Style Veggie Pizza");
            }
            case "clam" -> {
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("NY Style Clam Pizza");
            }
            case "pepperoni" -> {
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("NY Style Pepperoni Pizza");
            }
        }
        return pizza;
    }
}
