/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7a1;

import java.text.NumberFormat;
import java.util.Locale;

import com.vaadin.data.util.converter.StringToDoubleConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Table;

public class FormatTableValue extends AbstractTestUI {

    private static final String PERCENT_PROPERTY = "percent";
    private static final String CURRENCY_PROPERTY = "currency";
    private static final String DEFAULT_PROPERTY = "default";

    @Override
    protected void setup(VaadinRequest request) {
        Table table = new Table();
        table.setLocale(Locale.FRANCE);
        table.addContainerProperty(PERCENT_PROPERTY, Double.class, 0);
        table.addContainerProperty(CURRENCY_PROPERTY, Double.class, 0);
        table.addContainerProperty(DEFAULT_PROPERTY, Double.class, 0);

        Object itemId = table.addItem();
        table.getItem(itemId).getItemProperty(PERCENT_PROPERTY)
                .setValue(3.1415);
        table.getItem(itemId).getItemProperty(CURRENCY_PROPERTY)
                .setValue(3.1415);
        table.getItem(itemId).getItemProperty(DEFAULT_PROPERTY)
                .setValue(3.1415);

        table.setConverter(PERCENT_PROPERTY, new StringToDoubleConverter() {
            @Override
            protected NumberFormat getFormat(Locale locale) {
                return NumberFormat.getPercentInstance(locale);
            }
        });

        table.setConverter(CURRENCY_PROPERTY, new StringToDoubleConverter() {
            @Override
            protected NumberFormat getFormat(Locale locale) {
                return NumberFormat.getCurrencyInstance(locale);
            }
        });

        addComponent(table);
    }

    @Override
    protected String getTestDescription() {
        return "Mini tutorial for https://vaadin.com/wiki/-/wiki/Main/Formatting%20data%20in%20Table";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }

}
