/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.calendar.handler;

import java.util.Date;

import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventResize;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventResizeHandler;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.EditableCalendarEvent;

/**
 * Implements basic functionality needed to enable event resizing.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
@SuppressWarnings("serial")
public class BasicEventResizeHandler implements EventResizeHandler {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventResizeHandler
     * #eventResize
     * (com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventResize)
     */
    @Override
    public void eventResize(EventResize event) {
        CalendarEvent calendarEvent = event.getCalendarEvent();

        if (calendarEvent instanceof EditableCalendarEvent) {
            Date newStartTime = event.getNewStart();
            Date newEndTime = event.getNewEnd();

            EditableCalendarEvent editableEvent = (EditableCalendarEvent) calendarEvent;

            setDates(editableEvent, newStartTime, newEndTime);
        }
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
    protected void setDates(EditableCalendarEvent event, Date start, Date end) {
        event.setStart(start);
        event.setEnd(end);
    }
}
