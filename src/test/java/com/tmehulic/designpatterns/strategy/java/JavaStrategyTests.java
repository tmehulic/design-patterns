package com.tmehulic.designpatterns.strategy.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaStrategyTests {

    @Test
    public void testComparatorExample() {
        ComparatorExample example = new ComparatorExample();
        example.sort(String::compareTo);
        assertEquals("Alice", example.getNames().getFirst());

        example.sort((a, b) -> b.compareTo(a));
        assertEquals("John", example.getNames().getFirst());

        example.sort((a, b) -> a.length() - b.length());
        assertEquals("Bob", example.getNames().getFirst());
    }

    @Test
    public void testFilteringExample() {
        FilteringExample example = new FilteringExample();

        Assertions.assertFalse(example.filter(".xml").isEmpty());
        Assertions.assertTrue(example.filter(".text").isEmpty());
    }
}
