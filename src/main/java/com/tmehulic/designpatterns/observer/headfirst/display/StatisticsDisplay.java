package com.tmehulic.designpatterns.observer.headfirst.display;

import com.tmehulic.designpatterns.observer.headfirst.Observer;
import com.tmehulic.designpatterns.observer.headfirst.WeatherData;

public class StatisticsDisplay implements DisplayElement, Observer {

    private float maxTemperature;
    private float minTemperature;
    private float averageTemperature;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        if (weatherData.getTemperature() > maxTemperature) {
            maxTemperature = weatherData.getTemperature();
        }
        if (weatherData.getTemperature() < minTemperature) {
            minTemperature = weatherData.getTemperature();
        }
        averageTemperature = (averageTemperature + weatherData.getTemperature()) / 2;
        display();
    }

    @Override
    public void display() {
        System.out.println(
                "Avg/Max/Min temperature = "
                        + averageTemperature
                        + "/"
                        + maxTemperature
                        + "/"
                        + minTemperature);
    }
}
