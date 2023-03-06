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

/**
 * Internally used by the calendar
 *
 * @since 7.1
 */
public class WeekGridMinuteTimeRange {
    private final Date start;
    private final Date end;

    /**
     * Creates a Date time range between start and end date. Drops seconds from
     * the range.
     *
     * @param start
     *            Start time of the range
     * @param end
     *            End time of the range
     * @param clearSeconds
     *            Boolean Indicates, if seconds should be dropped from the range
     *            start and end
     */
    public WeekGridMinuteTimeRange(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        this.start.setSeconds(0);
        this.end.setSeconds(0);
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public static boolean doesOverlap(WeekGridMinuteTimeRange a,
            WeekGridMinuteTimeRange b) {
        boolean overlaps = a.getStart().compareTo(b.getEnd()) < 0
                && a.getEnd().compareTo(b.getStart()) > 0;
        return overlaps;
    }
}
