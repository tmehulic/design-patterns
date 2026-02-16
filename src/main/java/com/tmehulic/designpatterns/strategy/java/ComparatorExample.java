package com.tmehulic.designpatterns.strategy.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ComparatorExample {
    private final List<String> names;

    public ComparatorExample() {
        names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.add("Alice");
    }

    public void sort(BiFunction<String, String, Integer> comparator) {
        names.sort(comparator::apply);
    }

    public List<String> getNames() {
        return names;
    }
}
