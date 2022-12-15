/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class UncloseableWindowCloseShortcut extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Window uncloseable = new Window("Uncloseable",
                new Label("Try and close me with esc"));
        uncloseable.setClosable(false);
        addWindow(uncloseable);

        uncloseable.center();
        uncloseable.focus();
    }

    @Override
    protected String getTestDescription() {
        return "An uncloseable Window should not be closed with esc key.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 19700;
    }

}
