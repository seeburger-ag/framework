/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fieldgroup;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;

public class BasicCrudGrid extends AbstractBasicCrud {

    private Grid grid;

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);
        grid = new Grid();

        grid.setContainerDataSource(container);

        grid.setColumnOrder((Object[]) columns);
        grid.removeColumn("salary");
        grid.addSelectionListener(new SelectionListener() {

            @Override
            public void select(SelectionEvent event) {
                Item item = grid.getContainerDataSource()
                        .getItem(grid.getSelectedRow());
                form.edit((BeanItem<ComplexPerson>) item);
            }
        });

        grid.setSizeFull();

        addComponent(grid);
        addComponent(form);
        getLayout().setExpandRatio(grid, 1);
    }

    @Override
    protected void deselectAll() {
        grid.select(null);
    }

}
