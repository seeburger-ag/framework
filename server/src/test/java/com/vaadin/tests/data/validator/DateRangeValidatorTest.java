/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

import com.vaadin.data.validator.DateRangeValidator;
import com.vaadin.shared.ui.datefield.Resolution;

public class DateRangeValidatorTest {
    Calendar startDate = new GregorianCalendar(TimeZone.getTimeZone("GMT"),
            Locale.ENGLISH);
    Calendar endDate = new GregorianCalendar(TimeZone.getTimeZone("GMT"),
            Locale.ENGLISH);

    private DateRangeValidator cleanValidator;
    private DateRangeValidator minValidator;
    private DateRangeValidator maxValidator;
    private DateRangeValidator minMaxValidator;

    @Before
    public void setUp() {
        startDate.set(2000, Calendar.JANUARY, 1, 12, 0, 0);
        endDate.set(2000, Calendar.FEBRUARY, 20, 12, 0, 0);

        cleanValidator = new DateRangeValidator("Given date outside range",
                null, null, Resolution.DAY);
        minValidator = new DateRangeValidator("Given date before startDate",
                startDate.getTime(), null, Resolution.DAY);
        maxValidator = new DateRangeValidator("Given date after endDate", null,
                endDate.getTime(), Resolution.DAY);
        minMaxValidator = new DateRangeValidator("Given date outside range",
                startDate.getTime(), endDate.getTime(), Resolution.DAY);
    }

    @Test
    public void testNullValue() {
        assertTrue("Didn't accept null", cleanValidator.isValid(null));
        assertTrue("Didn't accept null", minValidator.isValid(null));
        assertTrue("Didn't accept null", maxValidator.isValid(null));
        assertTrue("Didn't accept null", minMaxValidator.isValid(null));
    }

    @Test
    public void testMinValue() {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"),
                Locale.ENGLISH);
        cal.setTime(startDate.getTime());
        cal.add(Calendar.SECOND, 1);

        assertTrue("Validator without ranges didn't accept value",
                cleanValidator.isValid(cal.getTime()));
        assertTrue("Didn't accept valid value",
                minValidator.isValid(cal.getTime()));

        cal.add(Calendar.SECOND, -3);

        assertFalse("Accepted too small value",
                minValidator.isValid(cal.getTime()));
    }

    @Test
    public void testMaxValue() {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"),
                Locale.ENGLISH);
        cal.setTime(endDate.getTime());
        cal.add(Calendar.SECOND, -1);

        assertTrue("Validator without ranges didn't accept value",
                cleanValidator.isValid(cal.getTime()));
        assertTrue("Didn't accept valid value",
                maxValidator.isValid(cal.getTime()));

        cal.add(Calendar.SECOND, 2);
        assertFalse("Accepted too large value",
                maxValidator.isValid(cal.getTime()));
    }

    @Test
    public void testMinMaxValue() {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"),
                Locale.ENGLISH);
        cal.setTime(endDate.getTime());

        assertTrue("Didn't accept valid value",
                minMaxValidator.isValid(cal.getTime()));
        cal.add(Calendar.SECOND, 1);
        assertFalse("Accepted too large value",
                minMaxValidator.isValid(cal.getTime()));
        cal.setTime(startDate.getTime());
        assertTrue("Didn't accept valid value",
                minMaxValidator.isValid(cal.getTime()));
        cal.add(Calendar.SECOND, -1);
        assertFalse("Accepted too small value",
                minMaxValidator.isValid(cal.getTime()));
    }
}
