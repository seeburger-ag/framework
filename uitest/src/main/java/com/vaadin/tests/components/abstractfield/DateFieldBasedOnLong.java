/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractfield;

import java.util.Date;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.PopupDateField;

public class DateFieldBasedOnLong extends AbstractComponentDataBindingTest {

    private Long l = null;
    private ObjectProperty<Long> property;

    @Override
    protected void createFields() {
        PopupDateField pdf = new PopupDateField("DateField");
        addComponent(pdf);
        property = new ObjectProperty<Long>(l, Long.class);
        pdf.setPropertyDataSource(property);

        property.setValue(new Date(2011 - 1900, 4, 6).getTime());

        addComponent(new Button("Set property value to 10000L",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        property.setValue(10000L);

                    }
                }));
    }

}
