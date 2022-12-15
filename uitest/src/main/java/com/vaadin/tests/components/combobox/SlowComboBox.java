/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import java.util.Map;

import com.vaadin.ui.ComboBox;

/**
 * A combo box component with delay. Can be useful to use while testing UI.
 */
public class SlowComboBox extends ComboBox {
    @Override
    public void changeVariables(Object source, Map<String, Object> variables) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.changeVariables(source, variables);
    }
}
