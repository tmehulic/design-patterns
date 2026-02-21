package com.tmehulic.designpatterns.observer.spring;

import com.tmehulic.designpatterns.observer.spring.event.EventListenerExample;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@SpringBootTest
public class SpringObserverTests {

    @MockitoSpyBean EventListenerExample eventListenerExample;

    @Test
    void eventListenerExampleTest() {
        eventListenerExample.publishEvent("Hi!");
        eventListenerExample.publishEvent("There!");

        Mockito.verify(eventListenerExample, Mockito.times(2)).handleEvent(Mockito.any());
    }

    @Test
    void contextListenerExampleTest() {
        Mockito.verify(eventListenerExample, Mockito.times(1)).onApplicationEvent(Mockito.any());
    }
}
