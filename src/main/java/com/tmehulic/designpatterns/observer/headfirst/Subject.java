package com.tmehulic.designpatterns.observer.headfirst;

public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
