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
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;

public class DateFieldChangeResolution extends AbstractTestUI {

    public static final String DATEFIELD_ID = "datefield";
    // The ID of a button is BUTTON_BASE_ID + resolution, e.g. button-month
    public static final String BUTTON_BASE_ID = "button-";

    @Override
    protected void setup(VaadinRequest request) {
        final DateField dateField = new PopupDateField("Enter date");
        dateField.setResolution(Resolution.YEAR);
        dateField.setId(DATEFIELD_ID);
        dateField.setImmediate(true);
        addComponent(dateField);

        Label l = new Label("Select resolution");
        addComponent(l);
        HorizontalLayout hlayout = new HorizontalLayout();
        addComponent(hlayout);
        for (final Resolution value : Resolution.values()) {
            String resolutionString = value.toString().toLowerCase();
            Button b = new Button(resolutionString);
            b.addClickListener(new ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    dateField.setResolution(value);
                }
            });
            b.setId(BUTTON_BASE_ID + resolutionString);
            hlayout.addComponent(b);
        }

    }

    @Override
    protected String getTestDescription() {
        return "The calendar should always have the correct resolution and the text field should be empty before selecting a date.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14174;
    }

}
