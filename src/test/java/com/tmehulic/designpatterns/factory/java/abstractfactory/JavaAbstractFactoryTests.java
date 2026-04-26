package com.tmehulic.designpatterns.factory.java.abstractfactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

public class JavaAbstractFactoryTests {

    @Test
    void testDocumentBuilderExample() throws URISyntaxException {
        DocumentBuilderExample example = new DocumentBuilderExample();

        String file =
                Paths.get(
                                Objects.requireNonNull(
                                                getClass().getClassLoader().getResource("text.xml"))
                                        .toURI())
                        .toString();

        String content = example.getElementContent(file, "test");
        assertNotNull(content);
        assertEquals("Test", content);
    }
}
