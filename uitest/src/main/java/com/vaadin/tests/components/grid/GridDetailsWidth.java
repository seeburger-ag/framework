/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.DetailsGenerator;
import com.vaadin.ui.Grid.RowReference;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class GridDetailsWidth extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);

        final Grid grid = new Grid();

        Column column = grid.addColumn("Hello", String.class);
        for (int i = 0; i < 3; i++) {
            grid.addRow("Hello " + i);
        }

        column.setWidth(600);
        grid.setWidth(400, Unit.PIXELS);

        grid.setDetailsGenerator(new DetailsGenerator() {

            @Override
            public Component getDetails(RowReference rowReference) {
                HorizontalLayout myLayout = new HorizontalLayout();
                TextArea textArea1 = new TextArea();
                TextArea textArea2 = new TextArea();
                textArea1.setSizeFull();
                textArea2.setSizeFull();
                myLayout.addComponent(textArea1);
                myLayout.addComponent(textArea2);
                myLayout.setWidth(100, Unit.PERCENTAGE);
                myLayout.setHeight(null);
                myLayout.setMargin(true);
                return myLayout;
            }
        });

        grid.addItemClickListener(new ItemClickListener() {

            @Override
            public void itemClick(ItemClickEvent event) {
                grid.setDetailsVisible(event.getItemId(),
                        !grid.isDetailsVisible(event.getItemId()));

            }
        });

        layout.addComponent(grid);

        addComponent(layout);
    }

    @Override
    protected Integer getTicketNumber() {
        return 18223;
    }

    @Override
    public String getDescription() {
        return "Tests that Escalator will not set explicit widths to the TD element in a details row.";
    }

}
