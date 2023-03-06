/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.calendar.schedule;

/**
 * Utility class used to represent a day when updating views. Only used
 * internally.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
public class CalendarDay {
    private String date;
    private String localizedDateFormat;
    private int dayOfWeek;
    private int week;
    private int yearOfWeek;

    public CalendarDay(String date, String localizedDateFormat, int dayOfWeek,
            int week, int yearOfWeek) {
        super();
        this.date = date;
        this.localizedDateFormat = localizedDateFormat;
        this.dayOfWeek = dayOfWeek;
        this.week = week;
        this.yearOfWeek = yearOfWeek;
    }

    public String getDate() {
        return date;
    }

    public String getLocalizedDateFormat() {
        return localizedDateFormat;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getWeek() {
        return week;
    }

    public int getYearOfWeek() {
        return yearOfWeek;
    }
}
