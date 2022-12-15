/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.calendar;

import java.io.Serializable;

/**
 * CalendarEventId contains static String identifiers for all Calendar events.
 * These are used both in the client and server side code.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
public class CalendarEventId implements Serializable {

    public static final String EVENTMOVE = "eventMove";
    public static final String RANGESELECT = "rangeSelect";
    public static final String FORWARD = "forward";
    public static final String BACKWARD = "backward";
    public static final String DATECLICK = "dateClick";
    public static final String WEEKCLICK = "weekClick";
    public static final String EVENTCLICK = "eventClick";
    public static final String EVENTRESIZE = "eventResize";
    public static final String ACTION = "action";
}
