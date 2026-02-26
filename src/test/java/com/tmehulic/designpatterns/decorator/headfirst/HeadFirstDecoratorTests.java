package com.tmehulic.designpatterns.decorator.headfirst;

import com.tmehulic.designpatterns.decorator.headfirst.beverage.Beverage;
import com.tmehulic.designpatterns.decorator.headfirst.beverage.DarkRoast;
import com.tmehulic.designpatterns.decorator.headfirst.beverage.Espresso;
import com.tmehulic.designpatterns.decorator.headfirst.beverage.HouseBland;
import com.tmehulic.designpatterns.decorator.headfirst.condiment.Mocha;
import com.tmehulic.designpatterns.decorator.headfirst.condiment.Soy;
import com.tmehulic.designpatterns.decorator.headfirst.condiment.Whip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeadFirstDecoratorTests {

    @Test
    void testBeverages() {
        Beverage espresso = new Espresso();

        Assertions.assertEquals("Espresso", espresso.getDescription());
        Assertions.assertEquals(1.99, espresso.cost(), 0.01);

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);

        Assertions.assertEquals(
                "Dark Roast Coffee, Mocha, Mocha, Whip", darkRoast.getDescription());
        Assertions.assertEquals(1.49, darkRoast.cost(), 0.01);

        Beverage houseBland = new HouseBland();
        houseBland = new Soy(houseBland);
        houseBland = new Mocha(houseBland);
        houseBland = new Whip(houseBland);

        Assertions.assertEquals(
                "House Blend Coffee, Soy, Mocha, Whip", houseBland.getDescription());
        Assertions.assertEquals(1.34, houseBland.cost(), 0.01);
    }

    @Test
    void testSizeBeverages() {
        Beverage espresso = new Espresso();
        espresso.setSize(Beverage.Size.TALL);

        Assertions.assertEquals("Espresso", espresso.getDescription());
        Assertions.assertEquals(1.99, espresso.cost(), 0.01);

        Beverage darkRoast = new DarkRoast();
        darkRoast.setSize(Beverage.Size.VENTI);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);

        Assertions.assertEquals(
                "Dark Roast Coffee, Mocha, Mocha, Whip", darkRoast.getDescription());
        Assertions.assertEquals(1.59, darkRoast.cost(), 0.01);

        Beverage houseBland = new HouseBland();
        houseBland.setSize(Beverage.Size.GRANDE);
        houseBland = new Soy(houseBland);
        houseBland = new Mocha(houseBland);
        houseBland = new Whip(houseBland);

        Assertions.assertEquals(
                "House Blend Coffee, Soy, Mocha, Whip", houseBland.getDescription());
        Assertions.assertEquals(1.39, houseBland.cost(), 0.01);
    }
}
