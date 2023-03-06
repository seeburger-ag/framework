/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.calendar;

import com.vaadin.ui.components.calendar.event.BasicEvent;

/**
 * Test CalendarEvent implementation.
 *
 * @see com.vaadin.addon.calendar.test.ui.Calendar.Event
 */
public class CalendarTestEvent extends BasicEvent {

    private static final long serialVersionUID = 2820133201983036866L;
    private String where;
    private Object data;

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
        fireEventChange();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        fireEventChange();
    }
}
