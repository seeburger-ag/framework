/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.serialization;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.server.DelegateWithoutStateClassComponent;

@Widgetset(TestingWidgetSet.NAME)
public class DelegateWithoutStateClassTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        DelegateWithoutStateClassComponent c = new DelegateWithoutStateClassComponent();
        c.setRows(10);
        addComponent(c);
    }

    @Override
    protected String getTestDescription() {
        return "The height of the text area should be 10 rows if @DelegateToWidget works properly for widget subclasses even if there is no state subclass.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(9561);
    }

}
