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
import java.util.Locale;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.DateField;
import com.vaadin.ui.VerticalLayout;

public class CustomDateFormatEEE extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 2, 14); // Friday

        DateField df = new DateField("Should display 14/03/2014 Fri");
        df.setResolution(Resolution.DAY);
        df.setLocale(new Locale("en", "US"));

        String pattern = "dd/MM/yyyy EEE";
        df.setDateFormat(pattern);
        df.setValue(cal.getTime());
        df.setWidth("200px");

        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(df);
        layout.setMargin(true);
        setContent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "Verifies that \"EEE\" works as a part of custom date pattern";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13443;
    }

}
