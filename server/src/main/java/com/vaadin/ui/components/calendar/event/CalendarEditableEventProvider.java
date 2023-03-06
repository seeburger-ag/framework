/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui.components.calendar.event;

/**
 * An event provider which allows adding and removing events
 *
 * @since 7.1.0
 * @author Vaadin Ltd.
 */
public interface CalendarEditableEventProvider extends CalendarEventProvider {

    /**
     * Adds an event to the event provider
     *
     * @param event
     *            The event to add
     */
    void addEvent(CalendarEvent event);

    /**
     * Removes an event from the event provider
     *
     * @param event
     *            The event
     */
    void removeEvent(CalendarEvent event);
}
