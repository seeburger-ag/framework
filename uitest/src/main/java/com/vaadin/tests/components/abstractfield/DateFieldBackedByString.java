/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractfield;

import com.vaadin.ui.DateField;

public class DateFieldBackedByString extends AbstractComponentDataBindingTest {

    private String s = null;

    @Override
    protected void createFields() {
        DateField df = new DateField("Date field");
        addComponent(df);
        df.setPropertyDataSource(
                new com.vaadin.data.util.ObjectProperty<String>(s,
                        String.class));

    }
}
