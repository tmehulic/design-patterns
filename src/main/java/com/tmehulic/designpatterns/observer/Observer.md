# The Observer Pattern

**The Observer Pattern** defines a one-to-many dependency between objects so that when one object changes state, all of
its dependents are notified and updated automatically.

## Applicability

Use the Observer pattern when changes to the state of one object may require changing other objects, and the actual set
of objects is unknown beforehand or changes dynamically.

Use the pattern when some objects in your app must observe others, but only for a limited time or in specific cases.

## Spring

Springs most popular implementation of the Observer pattern is the ApplicationEventPublisher. It is used to publish
events to interested subscribers.

The examples in the `spring` package showcase how the Observer pattern is used in Spring.

### 1. ApplicationEventPublisher

Spring's `ApplicationEventPublisher` is a strategy for publishing events to interested subscribers. It allows you to
decouple the event producers from the event consumers, making it easier to maintain and extend your application.

This is demonstrated in the `event` package.

* **The Observer Interface:** `org.springframework.context.ApplicationListener`
* **The Logic:** "Here is an event. Notify all interested listeners about it."

### 2. `@EventListener` Annotation

The `@EventListener` annotation is a Spring-specific annotation that allows you to subscribe to events published by
Spring's `ApplicationEventPublisher`. It provides a convenient way to define event listeners without having to implement
the
`ApplicationListener` interface.

This is demonstrated in the `event` package.

* **The Observer Interface:** `org.springframework.context.event.EventListenerMethodProcessor` (the component that
  processes `@EventListener` annotations and registers them as listeners)
* **The Logic:** "Here is an event. Notify all methods annotated with `@EventListener` that are interested in this event
  type."