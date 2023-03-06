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
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;

public class ComboBoxSuggestionPageLength extends AbstractTestUI {

    private static List<String> items = Arrays.asList("abc", "cde", "efg",
            "ghi", "ijk");

    @Override
    protected void setup(VaadinRequest request) {
        ComboBox cb = new ComboBox("Page length 0", items);
        cb.setPageLength(0);
        cb.setFilteringMode(FilteringMode.CONTAINS);
        addComponent(cb);

        cb = new ComboBox("Page length 2", items);
        cb.setPageLength(2);
        cb.setFilteringMode(FilteringMode.CONTAINS);
        addComponent(cb);
    }

    @Override
    protected String getTestDescription() {
        return "Filtering should also work when page length is set to zero.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14509;
    }

}
