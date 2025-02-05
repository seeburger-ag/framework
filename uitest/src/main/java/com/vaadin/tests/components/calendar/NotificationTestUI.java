/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.DateClickEvent;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.DateClickHandler;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

public class NotificationTestUI extends UI {

    private DummyEventProvider provider;

    private static class DummyEventProvider implements CalendarEventProvider {

        private int index;
        private List<CalendarEvent> events = new ArrayList<CalendarEvent>();

        public void addEvent(Date date) {
            BasicEvent e = new BasicEvent();
            e.setAllDay(true);
            e.setStart(date);
            e.setEnd(date);
            e.setCaption("Some event " + ++index);
            events.add(e);
        }

        @Override
        public List<CalendarEvent> getEvents(Date startDate, Date endDate) {
            return events;
        }

    }

    @Override
    protected void init(com.vaadin.server.VaadinRequest request) {
        GridLayout content = new GridLayout(1, 2);
        content.setSizeFull();
        content.setRowExpandRatio(1, 1.0f);
        setContent(content);
        final Button btn = new Button("Show working notification",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        Notification.show(
                                "This will disappear when you move your mouse!");
                    }
                });
        content.addComponent(btn);

        provider = new DummyEventProvider();
        final Calendar cal = new Calendar(provider);
        cal.setLocale(Locale.US);
        cal.setSizeFull();
        cal.setHandler(new DateClickHandler() {
            @Override
            public void dateClick(DateClickEvent event) {
                provider.addEvent(event.getDate());
                Notification.show(
                        "This should disappear, but if wont unless clicked.");

                // this requestRepaint call interferes with the notification
                cal.markAsDirty();
            }
        });
        content.addComponent(cal);

        java.util.Calendar javaCal = java.util.Calendar.getInstance();
        javaCal.set(java.util.Calendar.YEAR, 2000);
        javaCal.set(java.util.Calendar.MONTH, 0);
        javaCal.set(java.util.Calendar.DAY_OF_MONTH, 1);
        Date start = javaCal.getTime();
        javaCal.set(java.util.Calendar.DAY_OF_MONTH, 31);
        Date end = javaCal.getTime();

        cal.setStartDate(start);
        cal.setEndDate(end);
    }
}
