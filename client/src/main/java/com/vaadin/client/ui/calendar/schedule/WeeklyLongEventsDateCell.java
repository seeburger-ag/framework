/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.calendar.schedule;

import java.util.Date;

import com.google.gwt.user.client.ui.HTML;
import com.vaadin.client.ui.VCalendar;

/**
 * Represents a cell used in {@link WeeklyLongEvents}
 *
 * @since 7.1
 */
public class WeeklyLongEventsDateCell extends HTML implements HasTooltipKey {
    private Date date;
    private CalendarEvent calendarEvent;
    private VCalendar calendar;

    public WeeklyLongEventsDateCell() {
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setEvent(CalendarEvent event) {
        calendarEvent = event;
    }

    public CalendarEvent getEvent() {
        return calendarEvent;
    }

    public void setCalendar(VCalendar calendar) {
        this.calendar = calendar;
    }

    public VCalendar getCalendar() {
        return calendar;
    }

    @Override
    public Object getTooltipKey() {
        if (calendarEvent != null) {
            return calendarEvent.getIndex();
        }
        return null;
    }
}
