package com.tmehulic.designpatterns.factory.java.factorymethod;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Locale;

public class JavaFactoryMethodTests {

    @Test
    void testCalendarExample() {
        CalendarExample example = new CalendarExample();
        Calendar calendar = example.getCalendar(Locale.getDefault());
        assertNotNull(calendar);

        Calendar calendar2 = example.getCalendar(Locale.US);
        assertNotNull(calendar2);
    }

    @Test
    void testCharsetExample() {
        CharsetExample example = new CharsetExample();
        assertNotNull(example.getCharset("UTF-8"));
        assertNotNull(example.getCharset("ISO-8859-1"));
    }
}
