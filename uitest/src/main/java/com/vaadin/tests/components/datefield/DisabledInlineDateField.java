/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import java.util.Calendar;
import java.util.Date;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.DateField;
import com.vaadin.ui.InlineDateField;

public class DisabledInlineDateField extends AbstractTestUI {

    private static final Date testDate;
    static {
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 5, 5);
        testDate = cal.getTime();
    }

    @Override
    protected void setup(VaadinRequest request) {
        DateField df = new InlineDateField("Disabled");
        df.setValue(testDate);
        df.setEnabled(false);
        addComponent(df);

        df = new InlineDateField("Read-only");
        df.setValue(testDate);
        df.setReadOnly(true);
        addComponent(df);
    }

    @Override
    protected String getTestDescription() {
        return "Testing disabled and read-only modes of InlineDateField.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10262;
    }

}
