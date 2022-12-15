/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;

public class ComboBoxEmptyItemsKeyboardNavigation extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        ComboBox comboBox = new ComboBox();
        comboBox.addItems("foo", "bar");

        addComponent(comboBox);
    }
}
