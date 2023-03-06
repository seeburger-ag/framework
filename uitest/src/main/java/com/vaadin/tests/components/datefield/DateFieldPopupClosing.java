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

public class DateFieldPopupClosing extends AbstractTestUI {

    static final String DATEFIELD_ID = "datefield";

    @Override
    protected void setup(VaadinRequest request) {
        final DateField df = new DateField();
        df.setId(DATEFIELD_ID);
        addComponent(df);
    }

    @Override
    protected String getTestDescription() {
        return "DateField popup should be closed when click on popup button";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14857;
    }

}
