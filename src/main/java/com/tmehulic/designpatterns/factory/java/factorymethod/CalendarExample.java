package com.tmehulic.designpatterns.factory.java.factorymethod;

import java.util.Calendar;
import java.util.Locale;

public class CalendarExample {

    public Calendar getCalendar(Locale locale) {
        return Calendar.getInstance(locale);
    }
}
