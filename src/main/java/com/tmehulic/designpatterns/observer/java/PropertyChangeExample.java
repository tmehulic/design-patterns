package com.tmehulic.designpatterns.observer.java;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertyChangeExample {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String name;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        support.firePropertyChange("name", oldValue, name);
    }

    public String getName() {
        return name;
    }

    static class PropertyChangeExampleListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(
                    "The name changed from " + evt.getOldValue() + " to " + evt.getNewValue());
        }
    }
}
