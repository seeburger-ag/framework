/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Container;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.renderers.HtmlRenderer;

public class GridColumnAutoWidth extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new Grid(createContainer());
        grid.getColumn("fixed width narrow").setWidth(50);
        grid.getColumn("fixed width wide").setWidth(200);

        for (Object propertyId : grid.getContainerDataSource()
                .getContainerPropertyIds()) {
            Column column = grid.getColumn(propertyId);
            column.setExpandRatio(0);
            column.setRenderer(new HtmlRenderer());
            grid.getHeaderRow(0).getCell(propertyId)
                    .setHtml("<span>" + column.getHeaderCaption() + "</span>");
        }

        grid.setSelectionMode(SelectionMode.NONE);
        grid.setWidth("750px");
        addComponent(grid);
    }

    private static Container.Indexed createContainer() {
        IndexedContainer c = new IndexedContainer();
        c.addContainerProperty("equal width", String.class,
                "<span>equal width</span>");
        c.addContainerProperty("short", String.class,
                "<span>a very long cell content</span>");
        c.addContainerProperty("a very long header content", String.class,
                "<span>short</span>");
        c.addContainerProperty("fixed width narrow", String.class,
                "<span>fixed width narrow</span>");
        c.addContainerProperty("fixed width wide", String.class,
                "<span>fixed width wide</span>");
        c.addItem();
        return c;
    }
}
