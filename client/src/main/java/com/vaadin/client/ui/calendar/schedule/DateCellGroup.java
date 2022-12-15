/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.calendar.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Internally used by the calendar
 *
 * @since 7.1
 */
public class DateCellGroup {
    private WeekGridMinuteTimeRange range;
    private final List<Integer> items;

    public DateCellGroup(Integer index) {
        items = new ArrayList<Integer>();
        items.add(index);
    }

    public WeekGridMinuteTimeRange getDateRange() {
        return range;
    }

    public Date getStart() {
        return range.getStart();
    }

    public Date getEnd() {
        return range.getEnd();
    }

    public void setDateRange(WeekGridMinuteTimeRange range) {
        this.range = range;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void add(Integer index) {
        items.add(index);
    }
}
