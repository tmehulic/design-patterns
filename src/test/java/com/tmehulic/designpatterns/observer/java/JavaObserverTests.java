package com.tmehulic.designpatterns.observer.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaObserverTests {

    @Test
    void testPropertyChangeExample() {
        PropertyChangeExample example = new PropertyChangeExample();
        PropertyChangeExample.PropertyChangeExampleListener listener =
                new PropertyChangeExample.PropertyChangeExampleListener();
        example.addPropertyChangeListener(listener);
        example.setName("John"); // Output: The name changed from null to John
        example.setName("Jane"); // Output: The name changed from John to Jane
        example.setName("Bob"); // Output: The name changed from Jane to Bob
    }

    @Test
    void testObservableExample() {
        ObservableExample.NewsChannel channel = new ObservableExample.NewsChannel();
        ObservableExample.NewsPublisher publisher = new ObservableExample.NewsPublisher();
        publisher.addObserver(channel);
        publisher.setNews("Breaking News: New Study Shows...");
        Assertions.assertEquals(publisher.getNews(), channel.getNews());
    }
}
