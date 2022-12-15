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
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.DateField;
import com.vaadin.ui.VerticalLayout;

public class PopupClosingWithEsc extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        DateField df0 = new DateField("Minute");
        df0.setId("minute");
        df0.setResolution(Resolution.MINUTE);

        DateField df1 = new DateField("Day");
        df1.setId("day");
        df1.setResolution(Resolution.DAY);

        DateField df2 = new DateField("Month");
        df2.setId("month");
        df2.setResolution(Resolution.MONTH);

        DateField df3 = new DateField("Year");
        df3.setId("year");
        df3.setResolution(Resolution.YEAR);

        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.addComponents(df0, df1, df2, df3);
        setContent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "Testing that the DateField popup can be closed with ESC key.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12317;
    }

}
