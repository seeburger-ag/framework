/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.calendar.schedule;

import com.google.gwt.user.client.ui.Label;

/**
 * A label in the {@link SimpleWeekToolbar}
 *
 * @since 7.1
 */
public class WeekLabel extends Label {
    private int week;
    private int year;

    public WeekLabel(String string, int week2, int year2) {
        super(string);
        setStylePrimaryName("v-calendar-week-number");
        week = week2;
        year = year2;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
