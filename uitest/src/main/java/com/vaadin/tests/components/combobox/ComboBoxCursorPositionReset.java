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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class ComboBoxCursorPositionReset extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final HorizontalLayout root = new HorizontalLayout();
        root.setSizeFull();
        setContent(root);

        ComboBox combo = new ComboBox();
        combo.setImmediate(true);
        root.addComponent(combo);
        combo.addItem("Hello World");
        combo.addItem("Please click on the text");

        combo.setValue("Please click on the text");
        Label gap = new Label();
        root.addComponent(gap);
        root.setExpandRatio(gap, 1);

    }

    @Override
    protected String getTestDescription() {
        return "Clicking on the text in the ComboBox should position the caret where you clicked, not cause it to jump to the start or the end";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11152;
    }

}
