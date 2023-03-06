/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.TextField;

/**
 * Test UI for default contrast color value.
 *
 * @author Vaadin Ltd
 */
@Theme("tests-valo-contrast")
public class ContrastFontColor extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        TextField field = new TextField();
        addComponent(field);
    }

    @Override
    protected Integer getTicketNumber() {
        return 14793;
    }

    @Override
    protected String getTestDescription() {
        return "Provide a variable for default contrast value in valo-font-color function.";
    }

}
