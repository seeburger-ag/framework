/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import java.util.ArrayList;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Test for #12727: Panels get unnecessary scroll bars in WebKit when content is
 * 100% wide.
 */
@SuppressWarnings("serial")
public class Ticket12727 extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Panel panel = new Panel();

        VerticalLayout content = new VerticalLayout();
        panel.setContent(content);

        GridLayout gridLayout = new GridLayout();
        gridLayout.setHeight(null);
        gridLayout.setWidth(100, Unit.PERCENTAGE);
        content.addComponent(gridLayout);

        ListSelect listSelect = new ListSelect();

        listSelect.setWidth(100, Unit.PERCENTAGE);
        listSelect.setHeight(500, Unit.PIXELS);

        gridLayout.addComponent(listSelect);

        ArrayList<String> values = new ArrayList<String>();
        values.add("Value 1");
        values.add("Value 2");
        values.add("Value 3");

        ComboBox comboBox = new ComboBox(null, values);
        gridLayout.addComponent(comboBox);

        gridLayout.setMargin(true);

        setContent(panel);
    }
}
