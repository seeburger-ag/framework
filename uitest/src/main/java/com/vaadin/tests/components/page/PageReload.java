/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.page;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class PageReload extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        addButton("Press to reload", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getPage().reload();
            }
        });
        log("UI id: " + getUIId());
    }

    @Override
    protected String getTestDescription() {
        return "Tests Page.reload(). Click button to refresh the page.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10250;
    }

}
