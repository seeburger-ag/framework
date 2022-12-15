/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import java.util.ArrayList;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Container.Indexed;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;

@Theme("valo")
public class GridColumnWidthRecalculation extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();

        grid.addColumn("Column 1");
        grid.addColumn("Column 2");

        grid.addRow("Narrow",
                "Wiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiide");
        addComponent(grid);

        Button b = new Button("Swap content", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                swapData(grid);
            }
        });
        addComponent(b);

        b = new Button("Swap content and recalculate columns",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        swapData(grid);
                        grid.recalculateColumnWidths();

                    }
                });
        addComponent(b);
    }

    @SuppressWarnings("unchecked")
    protected void swapData(Grid grid) {
        Indexed dataSource = grid.getContainerDataSource();
        Object itemId = dataSource.getItemIds().iterator().next();
        Item item = dataSource.getItem(itemId);
        ArrayList<Object> pIds = new ArrayList<Object>(
                item.getItemPropertyIds());
        for (int i = 0; i < pIds.size() / 2; i++) {
            int j = pIds.size() - 1 - i;
            Object pid1 = pIds.get(i);
            Object pid2 = pIds.get(j);

            Property<Object> property1 = item.getItemProperty(pid1);
            Property<Object> property2 = item.getItemProperty(pid2);
            Object tmp = property1.getValue();
            property1.setValue(property2.getValue());
            property2.setValue(tmp);
        }
    }

    @Override
    protected String getTestDescription() {
        return "There should be a way to ask Grid to recalculate column widths from server-side.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 16748;
    }
}
