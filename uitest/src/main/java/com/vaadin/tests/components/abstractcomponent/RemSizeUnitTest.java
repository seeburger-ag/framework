/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.abstractcomponent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.WebBrowser;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

public class RemSizeUnitTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Label label = new Label("My height is 10.5 x 5  rem");
        label.setHeight("5rem");
        label.setWidth(10.5f, Unit.REM);

        // Rem not supported in ie8, fake using pixels
        WebBrowser webBrowser = getPage().getWebBrowser();
        if (webBrowser.isIE() && webBrowser.getBrowserMajorVersion() == 8) {
            label.setHeight("80px");
            label.setWidth("168px");
        }

        addComponent(label);
    }

    @Override
    protected String getTestDescription() {
        return "Tests that REM units are properly applied to the DOM";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(11279);
    }

}
