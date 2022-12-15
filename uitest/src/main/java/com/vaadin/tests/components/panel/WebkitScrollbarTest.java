/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.panel;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class WebkitScrollbarTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Panel panel = new Panel();

        VerticalLayout content = new VerticalLayout();
        panel.setContent(content);

        GridLayout gridLayout = new GridLayout();
        gridLayout.setHeight(null);
        gridLayout.setWidth(100, Unit.PERCENTAGE);
        content.addComponent(gridLayout);

        ListSelect listSelect = new ListSelect();

        listSelect.setWidth(100, Unit.PERCENTAGE);
        listSelect.setHeight(300, Unit.PIXELS);

        gridLayout.addComponent(listSelect);

        gridLayout.setMargin(true);

        setContent(panel);
    }

    @Override
    protected String getTestDescription() {
        return "When opening the window, it should NOT contain a horizontal";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12727;
    }

}
