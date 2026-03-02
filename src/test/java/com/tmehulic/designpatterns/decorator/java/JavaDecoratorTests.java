package com.tmehulic.designpatterns.decorator.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JavaDecoratorTests {

    @Test
    void testLowerCaseInputStream() {
        InputStream inputStream = new ByteArrayInputStream("Hello World!".getBytes());
        LowerCaseInputStream lowerCaseInputStream = new LowerCaseInputStream(inputStream);

        StringBuilder result = new StringBuilder();
        int c;
        while (true) {
            try {
                if ((c = lowerCaseInputStream.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            result.append((char) c);
        }

        Assertions.assertEquals("hello world!", result.toString());
    }

    @Test
    void testCollections() {
        List<String> list = new ArrayList<>();
        list.add("Hello");

        Assertions.assertDoesNotThrow(() -> list.add("World"));

        List<String> decoratedList = CollectionsExample.decorate(list);

        Assertions.assertThrows(
                UnsupportedOperationException.class, () -> decoratedList.add("Test"));
    }
}
