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
import java.util.List;

import com.vaadin.data.sort.SortOrder;
import com.vaadin.event.SortEvent;
import com.vaadin.event.SortEvent.SortListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;

/*
 * Test UI for checking that sort indicators of a Grid are updated when the sort order is changed by a
 * SortListener.
 */
public class GridSortIndicator extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid g = getGrid();
        addComponent(g);
        g.addSortListener(new SortListener() {
            private SortDirection oldSortDirection = null;

            @Override
            public void sort(SortEvent event) {
                List<SortOrder> currentSortOrder = new ArrayList<SortOrder>(
                        event.getSortOrder());
                if (currentSortOrder.size() == 1) {
                    // If the name column was clicked, set a new sort order for
                    // both columns. Otherwise, revert to oldSortDirection if it
                    // is not null.
                    List<SortOrder> newSortOrder = new ArrayList<SortOrder>();
                    SortDirection newSortDirection = oldSortDirection;
                    if (currentSortOrder.get(0).getPropertyId()
                            .equals("Name")) {
                        newSortDirection = SortDirection.ASCENDING.equals(
                                oldSortDirection) ? SortDirection.DESCENDING
                                        : SortDirection.ASCENDING;
                    }
                    if (newSortDirection != null) {
                        newSortOrder
                                .add(new SortOrder("Name", newSortDirection));
                        newSortOrder
                                .add(new SortOrder("Value", newSortDirection));
                        g.setSortOrder(newSortOrder);
                    }
                    oldSortDirection = newSortDirection;
                }
            }
        });
    }

    private final Grid getGrid() {
        Grid g = new Grid();
        g.addColumn("Name");
        g.addColumn("Value", Integer.class);
        g.addRow(new Object[] { "a", 4 });
        g.addRow(new Object[] { "b", 5 });
        g.addRow(new Object[] { "c", 3 });
        g.addRow(new Object[] { "a", 6 });
        g.addRow(new Object[] { "a", 2 });
        g.addRow(new Object[] { "c", 7 });
        g.addRow(new Object[] { "b", 1 });
        return g;
    }

    @Override
    public String getTestDescription() {
        return "When the first column is the primary sort column, both columns should have "
                + "a sort indicator with the same sort direction. Clicking on the right column "
                + "in that state should have no effect.";
    }

    @Override
    public Integer getTicketNumber() {
        return 17440;
    }
}
