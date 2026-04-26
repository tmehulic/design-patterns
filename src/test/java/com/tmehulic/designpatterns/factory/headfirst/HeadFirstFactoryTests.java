package com.tmehulic.designpatterns.factory.headfirst;

import com.tmehulic.designpatterns.factory.headfirst.pizza.Pizza;
import com.tmehulic.designpatterns.factory.headfirst.store.ChicagoPizzaStore;
import com.tmehulic.designpatterns.factory.headfirst.store.NYPizzaStore;
import com.tmehulic.designpatterns.factory.headfirst.store.PizzaStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeadFirstFactoryTests {

    @Test
    public void testNYStyleCheesePizza() {
        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        Assertions.assertEquals("NY Style Sauce and Cheese Pizza", pizza.getName());
    }

    @Test
    public void testChicagoStyleCheesePizza() {
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza pizza = chicagoStore.orderPizza("cheese");
        Assertions.assertEquals("Chicago Style Cheese Pizza", pizza.getName());
    }
}
