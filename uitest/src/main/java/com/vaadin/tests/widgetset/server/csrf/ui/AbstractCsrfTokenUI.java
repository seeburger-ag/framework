/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server.csrf.ui;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.server.csrf.CsrfButton;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

/**
 * Abstract UI to test the CSRF token issue as reported in (#14111)
 *
 * @since
 * @author Vaadin Ltd
 */
@SuppressWarnings("serial")
@Widgetset(TestingWidgetSet.NAME)
public abstract class AbstractCsrfTokenUI extends AbstractTestUI {

    public static final String PRESS_ID = "PressMe";

    @Override
    protected void setup(VaadinRequest request) {

        addComponent(new Label("The button's text is the client token:"));
        addComponent(new CsrfButton());
        addComponent(new Label("This one is from the server"));
        addComponent(new Label(getSession().getCsrfToken()));
        Button pressMe = new Button("Click me to send a request");
        pressMe.setId(PRESS_ID);
        addComponent(pressMe);
    }

    @Override
    protected String getTestDescription() {
        return "Remove csrfToken from the request if security protection is disabled.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14111;
    }

}
