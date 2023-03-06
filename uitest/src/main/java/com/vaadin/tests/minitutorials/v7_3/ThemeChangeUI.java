/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7_3;

import java.util.Arrays;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;

public class ThemeChangeUI extends UI {

    private String[] themes = { "valo", "reindeer", "runo", "chameleon" };

    @Override
    protected void init(VaadinRequest request) {
        ComboBox themePicker = new ComboBox("Theme", Arrays.asList(themes));
        themePicker.setValue(getTheme());

        themePicker.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                String theme = (String) event.getProperty().getValue();
                setTheme(theme);
            }
        });

        setContent(themePicker);
    }
}
