/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.calendar.schedule.dd;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ui.calendar.CalendarConnector;
import com.vaadin.client.ui.dd.VAbstractDropHandler;

/**
 * Abstract base class for calendar drop handlers.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 *
 */
public abstract class CalendarDropHandler extends VAbstractDropHandler {

    protected final CalendarConnector calendarConnector;

    /**
     * Constructor
     *
     * @param connector
     *            The connector of the calendar
     */
    public CalendarDropHandler(CalendarConnector connector) {
        calendarConnector = connector;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.terminal.gwt.client.ui.dd.VAbstractDropHandler#getConnector()
     */
    @Override
    public CalendarConnector getConnector() {
        return calendarConnector;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.terminal.gwt.client.ui.dd.VDropHandler#
     * getApplicationConnection ()
     */
    @Override
    public ApplicationConnection getApplicationConnection() {
        return calendarConnector.getClient();
    }

}
