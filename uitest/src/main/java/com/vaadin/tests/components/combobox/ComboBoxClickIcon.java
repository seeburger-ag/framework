/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;

/**
 * Test UI to check click on icon in the combobox.
 *
 * @author Vaadin Ltd
 */
public class ComboBoxClickIcon extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final List<String> items = new ArrayList<String>();
        items.add("A");
        items.add("B");
        items.add("C");
        final ComboBox combo = new ComboBox();
        combo.setImmediate(true);
        combo.setItemIcon(items.get(0), FontAwesome.ALIGN_CENTER);
        combo.setItemIcon(items.get(1), FontAwesome.ALIGN_CENTER);
        combo.setItemIcon(items.get(2), FontAwesome.ALIGN_CENTER);
        combo.addItems(items);
        combo.setTextInputAllowed(false);
        addComponent(combo);
    }

    @Override
    protected String getTestDescription() {
        return "Combobox icon should handle click events";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14624;
    }

}
