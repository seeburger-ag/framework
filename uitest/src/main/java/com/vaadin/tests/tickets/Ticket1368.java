/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.server.LegacyApplication;
import com.vaadin.tests.TestForTablesInitialColumnWidthLogicRendering;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Table;

/**
 */
public class Ticket1368 extends LegacyApplication {

    private Table t;

    @Override
    public void init() {

        final LegacyWindow mainWin = new LegacyWindow("Test app to #1368");
        setMainWindow(mainWin);

        t = TestForTablesInitialColumnWidthLogicRendering.getTestTable(3, 5);

        mainWin.addComponent(t);

        ComboBox addColumn = new ComboBox();
        addColumn.setImmediate(true);
        addColumn.setNewItemsAllowed(true);
        addColumn.setNewItemHandler(new ComboBox.NewItemHandler() {
            @Override
            public void addNewItem(String newItemCaption) {
                t.addContainerProperty(newItemCaption, String.class, "-");
            }
        });
        mainWin.addComponent(addColumn);

    }
}
