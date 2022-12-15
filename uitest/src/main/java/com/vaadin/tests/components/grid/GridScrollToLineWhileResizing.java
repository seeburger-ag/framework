/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalSplitPanel;

public class GridScrollToLineWhileResizing extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        final VerticalSplitPanel vsp = new VerticalSplitPanel();
        vsp.setWidth(500, Unit.PIXELS);
        vsp.setHeight(500, Unit.PIXELS);
        vsp.setSplitPosition(100, Unit.PERCENTAGE);
        addComponent(vsp);

        IndexedContainer indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("column1", String.class, "");

        for (int i = 0; i < 100; i++) {
            Item addItem = indexedContainer.addItem(i);
            addItem.getItemProperty("column1").setValue("cell" + i);
        }

        final Grid grid = new Grid(indexedContainer);
        grid.setSizeFull();

        grid.setSelectionMode(SelectionMode.SINGLE);
        grid.addSelectionListener(new SelectionListener() {

            @Override
            public void select(SelectionEvent event) {
                vsp.setSplitPosition(50, Unit.PERCENTAGE);
                grid.scrollTo(event.getSelected().iterator().next());
            }
        });

        vsp.setFirstComponent(grid);
    }

    @Override
    protected String getTestDescription() {
        return "Tests scrollToLine while moving SplitPanel split position to resize the Grid on the same round-trip.";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }

}
