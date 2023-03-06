/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.calendar;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.Component;

/**
 * All Calendar events extends this class.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 *
 */
@SuppressWarnings("serial")
public class CalendarComponentEvent extends Component.Event {

    /**
     * Set the source of the event
     *
     * @param source
     *            The source calendar
     *
     */
    public CalendarComponentEvent(Calendar source) {
        super(source);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.Component.Event#getComponent()
     */
    @Override
    public Calendar getComponent() {
        return (Calendar) super.getComponent();
    }
}
