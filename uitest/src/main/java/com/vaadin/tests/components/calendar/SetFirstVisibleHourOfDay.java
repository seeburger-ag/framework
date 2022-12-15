/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Calendar.TimeFormat;
import com.vaadin.ui.components.calendar.event.BasicEvent;

@Theme("tests-calendar")
public class SetFirstVisibleHourOfDay extends AbstractTestUI {

    private Calendar calendar;

    @Override
    protected void setup(VaadinRequest request) {
        calendar = new Calendar();

        try {
            BasicEvent event = new BasicEvent("EVENT NAME 1", "EVENT TOOLTIP 1",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse("2013-09-05 00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse("2013-09-05 13:00"));
            event.setStyleName("color1");
            calendar.addEvent(event);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            calendar.setStartDate(
                    new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-01"));
            calendar.setEndDate(
                    new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.setImmediate(true);
        calendar.setTimeFormat(TimeFormat.Format24H);
        calendar.setLocale(new Locale("en", "US"));

        calendar.setFirstVisibleHourOfDay(7);

        addComponent(calendar);
        calendar.setSizeFull();
        setSizeFull();
    }

    @Override
    protected String getTestDescription() {
        return "Calendar week and day views should work correctly when using setFirstVisibleHourOfDay()";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13431;
    }

}
