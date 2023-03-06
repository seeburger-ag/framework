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

import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventMoveHandler;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.MoveEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.EditableCalendarEvent;

/**
 * Implements basic functionality needed to enable moving events.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
@SuppressWarnings("serial")
public class BasicEventMoveHandler implements EventMoveHandler {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventMoveHandler
     * #eventMove
     * (com.vaadin.addon.calendar.ui.CalendarComponentEvents.MoveEvent)
     */
    @Override
    public void eventMove(MoveEvent event) {
        CalendarEvent calendarEvent = event.getCalendarEvent();

        if (calendarEvent instanceof EditableCalendarEvent) {

            EditableCalendarEvent editableEvent = (EditableCalendarEvent) calendarEvent;

            Date newFromTime = event.getNewStart();

            // Update event dates
            long length = editableEvent.getEnd().getTime()
                    - editableEvent.getStart().getTime();
            setDates(editableEvent, newFromTime,
                    new Date(newFromTime.getTime() + length));
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
