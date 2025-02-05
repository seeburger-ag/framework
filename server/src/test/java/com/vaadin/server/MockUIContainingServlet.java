/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import com.vaadin.ui.UI;

public class MockUIContainingServlet extends UI {

    public static class ServletInUI extends VaadinServlet {
        // This servlet should automatically be configured to use the
        // enclosing UI class
    }

    @Override
    protected void init(VaadinRequest request) {
        // Do nothing
    }
}
