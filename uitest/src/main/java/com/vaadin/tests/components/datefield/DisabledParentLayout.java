/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Vaadin Ltd
 */
public class DisabledParentLayout extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();

        content.setSpacing(true);
        content.setMargin(true);

        final VerticalLayout pane = new VerticalLayout();
        pane.addComponent(new DateField());

        content.addComponent(pane);

        Button button = new Button("Test");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                pane.setEnabled(!pane.isEnabled());
            }
        });
        content.addComponent(button);

        addComponent(content);
    }

    @Override
    protected String getTestDescription() {
        return "Data field should be functional after enabling disabled parent.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13124;
    }

}
