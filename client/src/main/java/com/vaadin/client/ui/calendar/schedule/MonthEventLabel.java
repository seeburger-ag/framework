/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.calendar.schedule;

import java.util.Date;

import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.user.client.ui.HTML;
import com.vaadin.client.Util;
import com.vaadin.client.ui.VCalendar;

/**
 * The label in a month cell
 *
 * @since 7.1
 */
public class MonthEventLabel extends HTML implements HasTooltipKey {

    private static final String STYLENAME = "v-calendar-event";

    private boolean timeSpecificEvent = false;
    private Integer eventIndex;
    private VCalendar calendar;
    private String caption;
    private Date time;

    private CalendarEvent calendarEvent;

    /**
     * Default constructor
     */
    public MonthEventLabel() {
        setStylePrimaryName(STYLENAME);

        addDomHandler(new ContextMenuHandler() {
            @Override
            public void onContextMenu(ContextMenuEvent event) {
                calendar.getMouseEventListener().contextMenu(event,
                        MonthEventLabel.this);
                event.stopPropagation();
                event.preventDefault();
            }
        }, ContextMenuEvent.getType());
    }

    public void setCalendarEvent(CalendarEvent e) {
        calendarEvent = e;
    }

    /**
     * Set the time of the event label
     *
     * @param date
     *            The date object that specifies the time
     */
    public void setTime(Date date) {
        time = date;
        renderCaption();
    }

    /**
     * Set the caption of the event label
     *
     * @param caption
     *            The caption string, can be HTML if
     *            {@link VCalendar#isEventCaptionAsHtml()} is true
     */
    public void setCaption(String caption) {
        this.caption = caption;
        renderCaption();
    }

    /**
     * Renders the caption in the DIV element
     */
    private void renderCaption() {
        StringBuilder html = new StringBuilder();
        String textOrHtml;
        if (calendar.isEventCaptionAsHtml()) {
            textOrHtml = caption;
        } else {
            textOrHtml = Util.escapeHTML(caption);
        }

        if (caption != null && time != null) {
            html.append("<span class=\"" + STYLENAME + "-time\">");
            html.append(calendar.getTimeFormat().format(time));
            html.append("</span> ");
            html.append(textOrHtml);
        } else if (caption != null) {
            html.append(textOrHtml);
        } else if (time != null) {
            html.append("<span class=\"" + STYLENAME + "-time\">");
            html.append(calendar.getTimeFormat().format(time));
            html.append("</span>");
        }
        super.setHTML(html.toString());
    }

    /**
     * Set the (server side) index of the event
     *
     * @param index
     *            The integer index
     */
    public void setEventIndex(int index) {
        eventIndex = index;
    }

    /**
     * Set the Calendar instance this label belongs to
     *
     * @param calendar
     *            The calendar instance
     */
    public void setCalendar(VCalendar calendar) {
        this.calendar = calendar;
    }

    /**
     * Is the event bound to a specific time
     *
     * @return
     */
    public boolean isTimeSpecificEvent() {
        return timeSpecificEvent;
    }

    /**
     * Is the event bound to a specific time
     *
     * @param timeSpecificEvent
     *            True if the event is bound to a time, false if it is only
     *            bound to the day
     */
    public void setTimeSpecificEvent(boolean timeSpecificEvent) {
        this.timeSpecificEvent = timeSpecificEvent;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.google.gwt.user.client.ui.HTML#setHTML(java.lang.String)
     */
    @Override
    public void setHTML(String html) {
        throw new UnsupportedOperationException(
                "Use setCaption() and setTime() instead");
    }

    @Override
    public Object getTooltipKey() {
        return eventIndex;
    }

    public CalendarEvent getCalendarEvent() {
        return calendarEvent;
    }
}
