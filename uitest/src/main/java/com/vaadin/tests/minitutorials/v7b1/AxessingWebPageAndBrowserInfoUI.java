/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7b1;

import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Page.UriFragmentChangedEvent;
import com.vaadin.server.Page.UriFragmentChangedListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class AxessingWebPageAndBrowserInfoUI extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        UI someUI = this;

        Page page = someUI.getPage();
        page.addBrowserWindowResizeListener(new BrowserWindowResizeListener() {
            @Override
            public void browserWindowResized(BrowserWindowResizeEvent event) {
                Notification.show("Window width=" + event.getWidth()
                        + ", height=" + event.getHeight());
            }
        });

        page.setUriFragment(page.getUriFragment() + "foo");
        page.addUriFragmentChangedListener(new UriFragmentChangedListener() {
            @Override
            public void uriFragmentChanged(UriFragmentChangedEvent event) {
                Notification.show("Fragment=" + event.getUriFragment());
            }
        });
    }

    @Override
    protected String getTestDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
