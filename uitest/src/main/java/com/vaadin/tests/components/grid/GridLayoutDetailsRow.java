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
import com.vaadin.ui.Grid.DetailsGenerator;
import com.vaadin.ui.Grid.RowReference;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

/**
 * Tests that details row displays GridLayout contents properly.
 *
 * @author Vaadin Ltd
 */
public class GridLayoutDetailsRow extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.setSizeFull();
        grid.addColumn("name", String.class);
        grid.addColumn("born", Integer.class);

        grid.addRow("Nicolaus Copernicus", 1543);
        grid.addRow("Galileo Galilei", 1564);
        grid.addRow("Johannes Kepler", 1571);

        addComponent(grid);

        grid.setDetailsGenerator(new DetailsGenerator() {
            @Override
            public Component getDetails(final RowReference rowReference) {
                final GridLayout detailsLayout = new GridLayout();
                detailsLayout.setSizeFull();
                detailsLayout.setHeightUndefined();

                final Label lbl1 = new Label("test1");
                lbl1.setId("lbl1");
                lbl1.setWidth("200px");
                detailsLayout.addComponent(lbl1);

                final Label lbl2 = new Label("test2");
                lbl2.setId("lbl2");
                detailsLayout.addComponent(lbl2);

                final Label lbl3 = new Label("test3");
                lbl3.setId("lbl3");
                detailsLayout.addComponent(lbl3);

                final Label lbl4 = new Label("test4");
                lbl4.setId("lbl4");
                detailsLayout.addComponent(lbl4);

                return detailsLayout;
            }
        });

        grid.addItemClickListener(new ItemClickListener() {
            @Override
            public void itemClick(final ItemClickEvent event) {
                final Object itemId = event.getItemId();
                grid.setDetailsVisible(itemId, !grid.isDetailsVisible(itemId));
            }
        });
    }

    @Override
    protected String getTestDescription() {
        return "GridLayout as part of Grid detail row should be correctly computed/displayed.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 18619;
    }
}
