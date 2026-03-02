package com.tmehulic.designpatterns.decorator.java;

import java.util.Collections;
import java.util.List;

public class CollectionsExample {

    public static List<String> decorate(List<String> items) {
        List<String> syncList = Collections.synchronizedList(items);
        return Collections.unmodifiableList(syncList);
    }
}
