/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;

/*
 * Used by PopupViewInEmbedded.html
 */
public class PopupViewInEmbeddedApplication extends TestBase {

    @Override
    protected void setup() {
        PopupView pop = new PopupView("Click me!",
                new Label("I popped up, woohoo!"));
        addComponent(pop);
    }

    @Override
    protected String getDescription() {
        return "Clicking on the popup link should pop up the popup on top of the link,"
                + " even though the application has been embedded inside a div.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 7110;
    }

}
