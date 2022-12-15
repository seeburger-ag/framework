/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import java.util.Arrays;
import java.util.Locale;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.NativeSelect;

public class FilteringTurkishLocale extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        final ComboBox comboBox = new ComboBox("Box",
                Arrays.asList("I without dot", "İ with dot"));
        comboBox.setNullSelectionAllowed(false);

        NativeSelect localeSelect = new NativeSelect("Locale",
                Arrays.asList(Locale.ENGLISH, new Locale("tr")));
        localeSelect.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                comboBox.setLocale((Locale) event.getProperty().getValue());
            }
        });
        localeSelect.setValue(Locale.ENGLISH);

        addComponents(localeSelect, comboBox);
    }

    @Override
    public String getDescription() {
        return "When the Turkish locale is used,"
                + " filtering for 'i' should show the option with a dot"
                + " while filtering for 'ı' should show the option witout a dot";
    }

}
