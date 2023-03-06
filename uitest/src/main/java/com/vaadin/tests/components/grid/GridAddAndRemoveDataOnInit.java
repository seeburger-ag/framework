/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Container.Indexed;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;

public class GridAddAndRemoveDataOnInit extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Grid gridAdd = new Grid();
        gridAdd.setHeight("240px");
        gridAdd.setWidth("140px");
        addComponent(gridAdd);
        Indexed dataSource = gridAdd.getContainerDataSource();
        dataSource.addContainerProperty("foo", Integer.class, 0);
        for (int i = 0; i < 10; ++i) {
            Object id = dataSource.addItem();
            dataSource.getItem(id).getItemProperty("foo").setValue(i);
        }
        dataSource = new IndexedContainer();
        dataSource.addContainerProperty("bar", Integer.class, 0);
        for (int i = 0; i < 10; ++i) {
            Object id = dataSource.addItem();
            dataSource.getItem(id).getItemProperty("bar").setValue(i);
        }
        Grid gridRemove = new Grid(dataSource);
        gridRemove.setHeight("150px");
        gridRemove.setWidth("140px");
        addComponent(gridRemove);
        for (int i = 0; i < 5; ++i) {
            dataSource.removeItem(dataSource.getIdByIndex(i));
        }
    }

    @Override
    protected String getTestDescription() {
        return "Foo";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13334;
    }
}
