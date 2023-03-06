/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.ui.PasswordField;

@Widgetset(TestingWidgetSet.NAME)
public class CapsLockWarningUI extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        PasswordField field = new PasswordField("Enter your password");
        CapsLockWarning.warnFor(field);

        addComponent(field);
    }

    @Override
    protected String getTestDescription() {
        return "Mini tutorial code for https://vaadin.com/wiki/-/wiki/Main/Creating%20a%20component%20extension";
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
