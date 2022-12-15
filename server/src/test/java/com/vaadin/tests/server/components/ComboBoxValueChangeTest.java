/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.components;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.vaadin.ui.AbstractField;
import com.vaadin.ui.ComboBox;

/**
 * Check that the value change listener for a combo box is triggered exactly
 * once when setting the value, at the correct time.
 *
 * See <a href="http://dev.vaadin.com/ticket/4394">Ticket 4394</a>.
 */
public class ComboBoxValueChangeTest
        extends AbstractFieldValueChangeTestBase<Object> {

    @Before
    public void setUp() {
        ComboBox combo = new ComboBox();
        combo.addItem("myvalue");
        super.setUp(combo);
    }

    @Override
    protected void setValue(AbstractField<Object> field) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("selected", new String[] { "myvalue" });
        ((ComboBox) field).changeVariables(field, variables);
    }

}
