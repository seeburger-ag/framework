/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;

@Theme("valo")
public class ComboBoxValoDoubleClick extends AbstractTestUI {

    // Quite impossible to autotest reliably as there must be a click to open
    // the popup and another click during the opening animation to reproduce the
    // bug. Manually a double click is just about the right timing.
    @Override
    protected void setup(VaadinRequest request) {
        ComboBox cb = new ComboBox("Double-click Me");
        for (int i = 0; i < 100; i++) {
            cb.addItem("Item-" + i);
        }
        addComponent(cb);
    }

    @Override
    public String getTestDescription() {
        return "ComboBox should remain usable even after double-clicking (affects only Valo theme with $v-overlay-animate-in).";
    }

    @Override
    protected Integer getTicketNumber() {
        return 17903;
    }

}
