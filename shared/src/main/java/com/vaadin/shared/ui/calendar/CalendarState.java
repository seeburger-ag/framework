/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.calendar;

import java.util.List;

import com.vaadin.shared.AbstractComponentState;

/**
 * @since 7.1.0
 * @author Vaadin Ltd.
 */
public class CalendarState extends AbstractComponentState {

    public boolean format24H;
    public String[] dayNames;
    public String[] monthNames;
    public int firstVisibleDayOfWeek = 1;
    public int lastVisibleDayOfWeek = 7;
    public int firstHourOfDay = 0;
    public int lastHourOfDay = 23;
    public int firstDayOfWeek;
    public int scroll;
    public String now;
    public List<CalendarState.Day> days;
    public List<CalendarState.Event> events;
    public List<CalendarState.Action> actions;
    public boolean eventCaptionAsHtml;

    public static class Day implements java.io.Serializable {
        public String date;
        public String localizedDateFormat;
        public int dayOfWeek;
        public int week;
        public int yearOfWeek;
    }

    public static class Action implements java.io.Serializable {

        public String caption;
        public String iconKey;
        public String actionKey;
        public String startDate;
        public String endDate;
    }

    public static class Event implements java.io.Serializable {
        public int index;
        public String caption;
        public String dateFrom;
        public String dateTo;
        public String timeFrom;
        public String timeTo;
        public String styleName;
        public String description;
        public boolean allDay;
    }
}
