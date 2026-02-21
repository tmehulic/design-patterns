package com.tmehulic.designpatterns.observer.headfirst;

import com.tmehulic.designpatterns.observer.headfirst.display.CurrentConditionsDisplay;
import com.tmehulic.designpatterns.observer.headfirst.display.ForecastDisplay;
import com.tmehulic.designpatterns.observer.headfirst.display.HeatIndexDisplay;
import com.tmehulic.designpatterns.observer.headfirst.display.StatisticsDisplay;

import org.junit.jupiter.api.Test;

import javax.swing.*;

public class HeadFirstObserverTests {

    @Test
    void testAllDisplays() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
