/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.panel;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class UndefinedSizeScrollbars extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setSizeFull();
        setContent(layout);

        GridLayout grid = new GridLayout();
        grid.setSpacing(true);

        TextField text1 = new TextField();
        text1.setCaption("Text1");
        text1.setRequired(true);

        TextField text2 = new TextField();
        text2.setCaption("Text2");
        text2.setRequired(true);

        ComboBox combo = new ComboBox();
        combo.setCaption("Combo1");

        CheckBox check = new CheckBox();
        check.setCaption("Check");

        grid.setColumns(2);
        grid.setRows(2);

        grid.addComponent(text1);
        grid.addComponent(text2);
        grid.addComponent(combo);
        grid.addComponent(check);

        grid.setSizeUndefined();

        Panel panel = new Panel();
        panel.setContent(grid);

        panel.setSizeUndefined();

        layout.addComponent(panel);
    }

}
