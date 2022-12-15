/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.server.ErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Grid;

public class GridEditorConverterNotFound extends AbstractTestUIWithLog {

    class Foo {
    }

    @Override
    protected void setup(VaadinRequest request) {

        Grid grid = new Grid();

        grid.addColumn("foo", Foo.class);
        grid.addRow(new Foo());
        grid.setEditorEnabled(true);
        grid.setErrorHandler(new ErrorHandler() {

            @Override
            public void error(com.vaadin.server.ErrorEvent event) {
                log(event.getThrowable().toString());
            }
        });

        addComponent(grid);
    }

    @Override
    protected Integer getTicketNumber() {
        return 17935;
    }

    @Override
    protected String getTestDescription() {
        return "Grid should gracefully handle bind failures when opening editor";
    }
}
