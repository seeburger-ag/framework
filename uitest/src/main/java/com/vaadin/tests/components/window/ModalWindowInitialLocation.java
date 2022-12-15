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
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class ModalWindowInitialLocation extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Window w = new Window();
        VerticalLayout layout = new VerticalLayout();
        // Add lots of contents so that it is easier to see whether the
        // window first appears in the wrong location.
        for (int i = 0; i < 50; i++) {
            final ListSelect listSelect = new ListSelect("Choose options");
            listSelect.setRows(4);
            listSelect.setWidth("100%");
            listSelect.setImmediate(true);
            listSelect.setMultiSelect(true);
            listSelect.setNullSelectionAllowed(true);
            listSelect.addItem(new String("Planning"));
            listSelect.addItem(new String("Executing"));
            listSelect.addItem(new String("Listing"));
            listSelect.addItem(new String("Thinking"));
            listSelect.addItem(new String("Sorting"));
            listSelect.addItem(new String("Ordering"));
            listSelect.select("Planning");
            listSelect.select("Ordering");
            layout.addComponent(listSelect);
        }

        w.setCaption("Person Form");
        w.setWidth("400px");
        w.setHeight("400px");
        w.setContent(layout);

        Button b = new Button("Open window");
        b.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                w.setModal(true);
                getUI().addWindow(w);
            }
        });
        addComponent(b);
    }

    @Override
    public String getTestDescription() {
        return "When the button is clicked, a window should appear in the center of the browser window without "
                + "flashing first in the upper left corner.";
    }

    @Override
    public Integer getTicketNumber() {
        return 16486;
    }
}
