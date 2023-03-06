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

import com.google.gwt.i18n.client.DateTimeFormat;
import com.vaadin.shared.ui.calendar.DateConstants;

/**
 * Utility class for {@link Date} operations
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
public class DateUtil {

    /**
     * Checks if dates are same day without checking datetimes.
     *
     * @param date1
     * @param date2
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean compareDate(Date date1, Date date2) {
        if (date1.getDate() == date2.getDate()
                && date1.getYear() == date2.getYear()
                && date1.getMonth() == date2.getMonth()) {
            return true;
        }
        return false;
    }

    /**
     * @param date
     *            the date to format
     *
     * @return given Date as String, for communicating to server-side
     */
    public static String formatClientSideDate(Date date) {
        DateTimeFormat dateformat_date = DateTimeFormat
                .getFormat(DateConstants.CLIENT_DATE_FORMAT);
        return dateformat_date.format(date);
    }

    /**
     * @param date
     *            the date to format
     * @return given Date as String, for communicating to server-side
     */
    public static String formatClientSideTime(Date date) {
        DateTimeFormat dateformat_date = DateTimeFormat
                .getFormat(DateConstants.CLIENT_TIME_FORMAT);
        return dateformat_date.format(date);
    }
}
