/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import java.util.Collection;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.PersonContainer;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Table;

public class SortableHeaderStyles extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        getPage().getStyles()
                .add(".v-table-header-sortable { font-weight: bold;}");

        PersonContainer container = PersonContainer.createWithTestData();

        Collection<?> sortableContainerPropertyIds = container
                .getSortableContainerPropertyIds();

        final OptionGroup sortableSelector = new OptionGroup("Sortable columns",
                sortableContainerPropertyIds);
        sortableSelector.setMultiSelect(true);
        sortableSelector.setValue(sortableContainerPropertyIds);

        final Table table = new Table() {
            @Override
            public Collection<?> getSortableContainerPropertyIds() {
                return (Collection<?>) sortableSelector.getValue();
            }
        };
        table.setContainerDataSource(container);

        sortableSelector.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                // Trigger repaint that will read the value again
                table.markAsDirty();
            }
        });

        addComponent(sortableSelector);
        addComponent(table);
    }
}
