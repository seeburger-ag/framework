/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PopupViewInTable extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Table t = new Table();
        t.addContainerProperty("text", String.class, "");
        t.addContainerProperty("pv", Component.class, null);
        t.addItem(new Object[] { "Foo", createPopupView() }, "foo");
        addComponent(t);
    }

    private PopupView createPopupView() {
        PopupView pv = new PopupView("Click me", createContent());
        return pv;
    }

    private Component createContent() {
        VerticalLayout vl = new VerticalLayout(new Label("Hello"),
                new Button("World"));
        return vl;
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
