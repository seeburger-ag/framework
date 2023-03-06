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
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;

/**
 * Test UI for issue #13488, where scrolling to the next page with pagelength 0
 * would break the rendering of any page except the first.
 *
 * @author Vaadin Ltd
 */
@SuppressWarnings("serial")
public class ComboboxPageLengthZeroScroll extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        ComboBox combobox = new ComboBox("New items enabled:");
        combobox.setPageLength(0);

        for (int i = 0; i++ < 10;) {
            combobox.addItem("1 AMERICAN SAMOA " + i);
            combobox.addItem("ANTIGUA AND BARBUDA " + i);
        }

        getLayout().addComponent(combobox);
        getLayout().addComponent(new Button("dummy"));
    }

    @Override
    protected String getTestDescription() {
        return "Scrolling with pagelength == 0 previously resulted in broken style, should be fixed now";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13488;
    }

}
