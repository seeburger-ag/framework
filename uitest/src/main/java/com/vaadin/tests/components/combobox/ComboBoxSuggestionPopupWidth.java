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
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;

public class ComboBoxSuggestionPopupWidth extends AbstractTestUI {

    private static List<String> items = Arrays.asList("abc", "cde", "efg",
            "ghi", "ijk", "more items 1", "more items 2", "more items 3",
            "Ridicilously long item caption so we can see how the ComboBox displays ridicilously long captions in the suggestion pop-up",
            "more items 4", "more items 5", "more items 6", "more items 7");

    @Override
    protected void setup(VaadinRequest request) {
        ComboBox cb = new ComboBox(
                "200px wide ComboBox with 100% wide suggestion popup", items);
        cb.setPopupWidth("100%");
        cb.setWidth("200px");
        cb.addStyleName("width-as-percentage");
        addComponent(cb);

    }

    @Override
    protected String getTestDescription() {
        return "Suggestion pop-up's width should be the same width as the ComboBox itself";
    }

    @Override
    protected Integer getTicketNumber() {
        return 19685;
    }

}
