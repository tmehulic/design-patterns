# Design patterns

This project covers the design patterns as they appear in the _Head First Design Patterns_ book combined with the actual
implementations in the Spring.

## Design principles

* **Identify the aspects of your application that vary and separate them from what stays the same.**  
  Take the parts that vary and encapsulate them so that later you can alter or extend the parts that vary without
  affecting those that don't.


* **Program to an interface, not an implementation.**  
  This can be also referred as a program to a super type.


* **Favor composition over inheritance.**  
  This allows us to change the behavior of the object at runtime.


* **Strive for loosely coupled designs between objects that interact.**  
  Loosely coupled designs allow you to change one part of the system without affecting other parts. This is often
  achieved by using interfaces and dependency injection.

## Behavioral patterns

[Strategy](src/main/java/com/tmehulic/designpatterns/strategy/Strategy.md)
[Observer](src/main/java/com/tmehulic/designpatterns/observer/Observer.md)

## Creational patterns

## Structural patterns