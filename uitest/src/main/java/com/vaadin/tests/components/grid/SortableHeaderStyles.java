/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import java.util.Collection;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.PersonContainer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.OptionGroup;

@Theme("valo")
public class SortableHeaderStyles extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        getPage().getStyles().add(
                ".valo .v-grid-header th.v-grid-cell.sortable { font-weight: bold;}");

        PersonContainer container = PersonContainer.createWithTestData();

        Collection<?> sortableContainerPropertyIds = container
                .getSortableContainerPropertyIds();

        final OptionGroup sortableSelector = new OptionGroup("Sortable columns",
                sortableContainerPropertyIds);
        sortableSelector.setMultiSelect(true);
        sortableSelector.setValue(sortableContainerPropertyIds);

        final Grid grid = new Grid(container);

        sortableSelector.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                Collection<?> sortableCols = (Collection<?>) sortableSelector
                        .getValue();
                for (Column column : grid.getColumns()) {
                    column.setSortable(
                            sortableCols.contains(column.getPropertyId()));
                }
            }
        });

        addComponent(sortableSelector);
        addComponent(grid);
    }

}
