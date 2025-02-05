/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

/**
 * Class for representing a date range.
 *
 * @since 7.1.0
 * @author Vaadin Ltd.
 *
 */
@SuppressWarnings("serial")
public class CalendarDateRange implements Serializable {

    private Date start;

    private Date end;

    private final transient TimeZone tz;

    /**
     * Constructor
     *
     * @param start
     *            The start date and time of the date range
     * @param end
     *            The end date and time of the date range
     */
    public CalendarDateRange(Date start, Date end, TimeZone tz) {
        super();
        this.start = start;
        this.end = end;
        this.tz = tz;
    }

    /**
     * Get the start date of the date range
     *
     * @return the start Date of the range
     */
    public Date getStart() {
        return start;
    }

    /**
     * Get the end date of the date range
     *
     * @return the end Date of the range
     */
    public Date getEnd() {
        return end;
    }

    /**
     * Is a date in the date range
     *
     * @param date
     *            The date to check
     * @return true if the date range contains a date start and end of range
     *         inclusive; false otherwise
     */
    public boolean inRange(Date date) {
        if (date == null) {
            return false;
        }

        return date.compareTo(start) >= 0 && date.compareTo(end) <= 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CalendarDateRange [start=" + start + ", end=" + end + "]";
    }

}
