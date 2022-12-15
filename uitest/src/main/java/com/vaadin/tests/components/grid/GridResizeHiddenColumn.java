/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.tests.fieldgroup.ComplexPerson;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.ColumnResizeEvent;
import com.vaadin.ui.Grid.ColumnResizeListener;

@SuppressWarnings("serial")
public class GridResizeHiddenColumn extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new Grid();
        grid.setContainerDataSource(ComplexPerson.createContainer(100));
        grid.setColumns("firstName", "lastName", "gender", "birthDate");
        grid.getColumn("firstName").setHidable(true);
        grid.getColumn("lastName").setHidable(true).setHidden(true);
        grid.getColumn("gender").setHidable(true).setHidden(true);
        grid.getColumn("birthDate").setHidable(true);

        addComponent(grid);

        grid.addColumnResizeListener(new ColumnResizeListener() {
            @Override
            public void columnResize(ColumnResizeEvent event) {
                log(String.format("Column resized: id=%s, width=%s",
                        event.getColumn().getPropertyId(),
                        event.getColumn().getWidth()));
            }
        });
    }

    @Override
    protected String getTestDescription() {
        return "Resize columns and then make hidden column visible. The originally hidden column should have an extended width.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 19826;
    }

    @Override
    public String getDescription() {
        return "Tests resize when columns with undefined width (-1) are hidden";
    }
}
