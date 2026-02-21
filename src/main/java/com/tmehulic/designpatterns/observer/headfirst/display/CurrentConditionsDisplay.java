package com.tmehulic.designpatterns.observer.headfirst.display;

import com.tmehulic.designpatterns.observer.headfirst.Observer;
import com.tmehulic.designpatterns.observer.headfirst.WeatherData;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

    private float temperature;
    private float humidity;

    /**
     * The book reasons this as a handy reference if we were to unsubscribe later. I think the
     * correct approach would be to have a collection of Subjects rather than tightly coupling it
     * like this...
     */
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println(
                "Current conditions: " + temperature + "C degrees and " + humidity + "% humidity");
    }
}
