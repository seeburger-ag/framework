/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.calendar;

import java.util.Date;
import java.util.Map;

import com.vaadin.event.dd.DropTarget;
import com.vaadin.event.dd.TargetDetailsImpl;
import com.vaadin.ui.Calendar;

/**
 * Drop details for {@link Calendar}. When something is dropped on the Calendar,
 * this class contains the specific details of the drop point. Specifically,
 * this class gives access to the date where the drop happened. If the Calendar
 * was in weekly mode, the date also includes the start time of the slot.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
@SuppressWarnings("serial")
public class CalendarTargetDetails extends TargetDetailsImpl {

    private boolean hasDropTime;

    public CalendarTargetDetails(Map<String, Object> rawDropData,
            DropTarget dropTarget) {
        super(rawDropData, dropTarget);
    }

    /**
     * @return true if {@link #getDropTime()} will return a date object with the
     *         time set to the start of the time slot where the drop happened
     */
    public boolean hasDropTime() {
        return hasDropTime;
    }

    /**
     * Does the dropped item have a time associated with it
     *
     * @param hasDropTime
     */
    public void setHasDropTime(boolean hasDropTime) {
        this.hasDropTime = hasDropTime;
    }

    /**
     * @return the date where the drop happened
     */
    public Date getDropTime() {
        if (hasDropTime) {
            return (Date) getData("dropTime");
        } else {
            return (Date) getData("dropDay");
        }
    }

    /**
     * @return the {@link Calendar} instance which was the target of the drop
     */
    public Calendar getTargetCalendar() {
        return (Calendar) getTarget();
    }
}
