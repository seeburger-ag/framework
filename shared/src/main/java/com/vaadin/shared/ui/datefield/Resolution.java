/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.datefield;

import java.util.ArrayList;
import java.util.List;

/**
 * Resolutions for DateFields
 *
 * @author Vaadin Ltd.
 * @since 7.0
 */
public enum Resolution {
    // Values from Calendar.SECOND etc. Set as ints to avoid Calendar dependency
    // (does not exist on the client side)
    SECOND(13), MINUTE(12), HOUR(11), DAY(5), MONTH(2), YEAR(1);

    private int calendarField;

    private Resolution(int calendarField) {
        this.calendarField = calendarField;
    }

    /**
     * Returns the field in java.util.Calendar that corresponds to this
     * resolution.
     *
     * @return one of the field numbers used by Calendar
     */
    public int getCalendarField() {
        return calendarField;
    }

    /**
     * Returns the resolutions that are higher or equal to the given resolution,
     * starting from the given resolution. In other words passing DAY to this
     * methods returns DAY,MONTH,YEAR
     *
     * @param r
     *            The resolution to start from
     * @return An iterable for the resolutions higher or equal to r
     */
    public static Iterable<Resolution> getResolutionsHigherOrEqualTo(
            Resolution r) {
        List<Resolution> resolutions = new ArrayList<Resolution>();
        Resolution[] values = Resolution.values();
        for (int i = r.ordinal(); i < values.length; i++) {
            resolutions.add(values[i]);
        }
        return resolutions;
    }

    /**
     * Returns the resolutions that are lower than the given resolution,
     * starting from the given resolution. In other words passing DAY to this
     * methods returns HOUR,MINUTE,SECOND.
     *
     * @param r
     *            The resolution to start from
     * @return An iterable for the resolutions lower than r
     */
    public static List<Resolution> getResolutionsLowerThan(Resolution r) {
        List<Resolution> resolutions = new ArrayList<Resolution>();
        Resolution[] values = Resolution.values();
        for (int i = r.ordinal() - 1; i >= 0; i--) {
            resolutions.add(values[i]);
        }
        return resolutions;
    }
}
