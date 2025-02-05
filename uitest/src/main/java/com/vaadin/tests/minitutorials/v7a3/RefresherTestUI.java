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
import com.vaadin.tests.minitutorials.v7a3.Refresher.RefreshEvent;
import com.vaadin.tests.minitutorials.v7a3.Refresher.RefreshListener;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

@Widgetset(TestingWidgetSet.NAME)
public class RefresherTestUI extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Refresher refresher = new Refresher(this);
        refresher.setInterval(1000);
        refresher.addRefreshListener(new RefreshListener() {
            @Override
            public void refresh(RefreshEvent event) {
                System.out.println("Got refresh");
            }
        });
        addComponent(new Button("Remove refresher", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                removeExtension(refresher);
            }
        }));
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
