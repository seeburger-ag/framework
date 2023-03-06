/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.DateField;
import com.vaadin.ui.InlineDateField;

import java.util.Locale;

public class DateRangeWithSqlDate extends AbstractTestUI {

    // 2014-12-01
    private static final java.sql.Date startDate = new java.sql.Date(
            1417467822699L);

    // 2014-12-02
    private static final java.sql.Date endDate = new java.sql.Date(
            1417554763317L);

    @Override
    protected void setup(VaadinRequest request) {
        DateField df = new InlineDateField();
        df.setLocale(Locale.US);
        df.setRangeStart(startDate);
        df.setRangeEnd(endDate);

        df.setValue(startDate);

        addComponent(df);
    }

    @Override
    protected String getTestDescription() {
        return "Test that java.sql.Date can be given to specify date range start and end dates.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 15342;
    }

}
