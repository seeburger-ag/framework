/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;

public class DateFieldKeyboardInput extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Calendar c = new GregorianCalendar(Locale.ENGLISH);
        c.set(2014, 0, 15);
        final PopupDateField dateField = new PopupDateField("Select date",
                c.getTime());
        dateField.setDateFormat("dd.MM.yyyy");
        addComponent(dateField);
        dateField.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                addComponent(new Label("Date has been changed."));
            }
        });
    }

    @Override
    public Integer getTicketNumber() {
        return 16677;
    }

    @Override
    public String getTestDescription() {
        return "When a new date is entered in the text field using the keyboard, pressing the return key after typing the date, "
                + "a label with the text 'Date has been changed' should appear.";
    }
}