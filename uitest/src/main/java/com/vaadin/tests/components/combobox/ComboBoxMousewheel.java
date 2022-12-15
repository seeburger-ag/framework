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

/**
 * Tests mousewheel handling in ComboBox.
 *
 * @author Vaadin Ltd
 */
public class ComboBoxMousewheel extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(createComboBox("Paged"));

        ComboBox cb = createComboBox("Unpaged");
        cb.setPageLength(0);
        addComponent(cb);
    }

    private ComboBox createComboBox(String caption) {
        ComboBox cb = new ComboBox(caption);
        cb.setId(caption);
        cb.setImmediate(true);
        for (int i = 1; i < 100; i++) {
            cb.addItem("Item " + i);
        }
        return cb;
    }

    @Override
    protected String getTestDescription() {
        return "ComboBox scrolling should be possible to both directions on Paged + IE as well.<br>"
                + "IE should not move paging up when scrolled down.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 16918;
    }

}
