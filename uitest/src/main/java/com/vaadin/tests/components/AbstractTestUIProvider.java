/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components;

import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WebBrowser;

public abstract class AbstractTestUIProvider extends UIProvider {
    protected abstract String getTestDescription();

    protected abstract Integer getTicketNumber();

    protected WebBrowser getBrowser() {
        WebBrowser webBrowser = VaadinSession.getCurrent().getBrowser();
        return webBrowser;
    }
}
