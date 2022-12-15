/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.calendar;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.table.DndTableTargetDetails;
import com.vaadin.ui.Calendar;

/**
 * Test UI for calendar as a drop target: CalendarTargetDetails should provide
 * getMouseEvent() method.
 *
 * @author Vaadin Ltd
 */
public class DndCalendarTargetDetails extends DndTableTargetDetails {

    @Override
    protected void setup(VaadinRequest request) {
        createSourceTable();

        Calendar calendar = new Calendar();
        calendar.addStyleName("target");
        calendar.setDropHandler(new TestDropHandler());
        calendar.setWidth(100, Unit.PERCENTAGE);
        addComponent(calendar);
    }

    @Override
    protected String getTestDescription() {
        return "Mouse details should be available for CalendarTargetDetails DnD when calendar is a target";
    }

}
