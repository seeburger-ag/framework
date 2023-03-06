/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.calendar.handler;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.vaadin.ui.components.calendar.CalendarComponentEvents.WeekClick;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.WeekClickHandler;

/**
 * Implements basic functionality needed to change to week view when a week
 * number is clicked.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
@SuppressWarnings("serial")
public class BasicWeekClickHandler implements WeekClickHandler {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.addon.calendar.ui.CalendarComponentEvents.WeekClickHandler
     * #weekClick
     * (com.vaadin.addon.calendar.ui.CalendarComponentEvents.WeekClick)
     */
    @Override
    public void weekClick(WeekClick event) {
        int week = event.getWeek();
        int year = event.getYear();

        // set correct year and month
        Calendar javaCalendar = event.getComponent().getInternalCalendar();
        javaCalendar.set(GregorianCalendar.YEAR, year);
        javaCalendar.set(GregorianCalendar.WEEK_OF_YEAR, week);

        // starting at the beginning of the week
        javaCalendar.set(GregorianCalendar.DAY_OF_WEEK,
                javaCalendar.getFirstDayOfWeek());
        Date start = javaCalendar.getTime();

        // ending at the end of the week
        javaCalendar.add(GregorianCalendar.DATE, 6);
        Date end = javaCalendar.getTime();

        setDates(event, start, end);

        // times are automatically expanded, no need to worry about them
    }

    /**
     * Set the start and end dates for the event
     *
     * @param event
     *            The event that the start and end dates should be set
     * @param start
     *            The start date
     * @param end
     *            The end date
     */
    protected void setDates(WeekClick event, Date start, Date end) {
        event.getComponent().setStartDate(start);
        event.getComponent().setEndDate(end);
    }

}
