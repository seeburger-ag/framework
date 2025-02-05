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

import com.vaadin.shared.ui.calendar.DateConstants;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.BackwardEvent;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.BackwardHandler;

/**
 * Implements basic functionality needed to enable backwards navigation.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
@SuppressWarnings("serial")
public class BasicBackwardHandler implements BackwardHandler {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.addon.calendar.ui.CalendarComponentEvents.BackwardHandler#
     * backward
     * (com.vaadin.addon.calendar.ui.CalendarComponentEvents.BackwardEvent)
     */
    @Override
    public void backward(BackwardEvent event) {
        Date start = event.getComponent().getStartDate();
        Date end = event.getComponent().getEndDate();

        // calculate amount to move back
        int durationInDays = (int) (((end.getTime()) - start.getTime())
                / DateConstants.DAYINMILLIS);
        durationInDays++;
        // for week view durationInDays = -7, for day view durationInDays = -1
        durationInDays = -durationInDays;

        // set new start and end times
        Calendar javaCalendar = event.getComponent().getInternalCalendar();
        javaCalendar.setTime(start);
        javaCalendar.add(java.util.Calendar.DATE, durationInDays);
        Date newStart = javaCalendar.getTime();

        javaCalendar.setTime(end);
        javaCalendar.add(java.util.Calendar.DATE, durationInDays);
        Date newEnd = javaCalendar.getTime();

        if (start.equals(end)) { // day view
            int firstDay = event.getComponent().getFirstVisibleDayOfWeek();
            int lastDay = event.getComponent().getLastVisibleDayOfWeek();
            int dayOfWeek = javaCalendar.get(Calendar.DAY_OF_WEEK);

            // we suppose that 7 >= lastDay >= firstDay >= 1
            while (!(firstDay <= dayOfWeek && dayOfWeek <= lastDay)) {
                javaCalendar.add(java.util.Calendar.DATE, -1);
                dayOfWeek = javaCalendar.get(Calendar.DAY_OF_WEEK);
            }

            newStart = javaCalendar.getTime();
            newEnd = javaCalendar.getTime();
        }

        setDates(event, newStart, newEnd);
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
    protected void setDates(BackwardEvent event, Date start, Date end) {
        event.getComponent().setStartDate(start);
        event.getComponent().setEndDate(end);
    }
}
