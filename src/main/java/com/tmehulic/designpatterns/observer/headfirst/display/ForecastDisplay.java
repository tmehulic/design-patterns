package com.tmehulic.designpatterns.observer.headfirst.display;

import com.tmehulic.designpatterns.observer.headfirst.Observer;
import com.tmehulic.designpatterns.observer.headfirst.WeatherData;

public class ForecastDisplay implements DisplayElement, Observer {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
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
                "Forecast for tomorrow: Temperature "
                        + temperature
                        + "C degrees and "
                        + humidity
                        + "% humidity");
    }
}
