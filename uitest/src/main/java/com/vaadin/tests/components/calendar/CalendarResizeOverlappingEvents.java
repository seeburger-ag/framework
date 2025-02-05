/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

/**
 *
 * @author Vaadin Ltd
 */
public class CalendarResizeOverlappingEvents extends AbstractTestUI {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        Calendar calendar = new Calendar(new CalendarEventProvider() {

            @Override
            public List<CalendarEvent> getEvents(Date startDate, Date endDate) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
                List<CalendarEvent> events = new ArrayList<CalendarEvent>();
                try {
                    java.util.Calendar today = java.util.Calendar.getInstance();

                    String todayString = dayFormat.format(today.getTime());

                    Date date1 = format.parse(todayString + " 09:00:00");
                    Date date2 = format.parse(todayString + " 11:00:00");
                    Date date3 = format.parse(todayString + " 12:00:00");
                    Date date4 = format.parse(todayString + " 14:00:00");
                    Date date5 = format.parse(todayString + " 15:00:00");
                    Date date6 = format.parse(todayString + " 17:00:00");

                    CalendarEvent event1 = new BasicEvent("First", "", date1,
                            date2);
                    CalendarEvent event2 = new BasicEvent("Second", "", date3,
                            date4);
                    CalendarEvent event3 = new BasicEvent("Third", "", date5,
                            date6);

                    events.add(event1);
                    events.add(event2);
                    events.add(event3);
                } catch (ParseException e) {
                }
                return events;
            }
        });
        calendar.setSizeFull();
        setContent(calendar);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Verify the widths of the events are correctly recalculated when these are resized and overlapped";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 13961;
    }
}
