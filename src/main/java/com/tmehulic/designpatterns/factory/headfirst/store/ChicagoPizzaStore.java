package com.tmehulic.designpatterns.factory.headfirst.store;

import com.tmehulic.designpatterns.factory.headfirst.ingredient.ChicagoPizzaIngredientFactory;
import com.tmehulic.designpatterns.factory.headfirst.ingredient.PizzaIngredientFactory;
import com.tmehulic.designpatterns.factory.headfirst.pizza.CheesePizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.ClamPizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.PepperoniPizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.Pizza;
import com.tmehulic.designpatterns.factory.headfirst.pizza.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

    PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case "cheese" -> {
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Chicago Style Cheese Pizza");
            }
            case "veggie" -> {
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("Chicago Style Veggie Pizza");
            }
            case "clam" -> {
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("Chicago Style Clam Pizza");
            }
            case "pepperoni" -> {
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("Chicago Style Pepperoni Pizza");
            }
        }

        return pizza;
    }
}
