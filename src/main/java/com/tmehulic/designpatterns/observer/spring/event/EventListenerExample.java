package com.tmehulic.designpatterns.observer.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerExample {
    public record Event(String message) {}

    private final ApplicationEventPublisher publisher;

    public EventListenerExample(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener
    public void handleEvent(Event event) {
        System.out.println(event.message());
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(
                "Context refreshed event received: "
                        + event.getApplicationContext().getDisplayName());
    }

    public void publishEvent(String message) {
        publisher.publishEvent(new Event(message));
    }
}
