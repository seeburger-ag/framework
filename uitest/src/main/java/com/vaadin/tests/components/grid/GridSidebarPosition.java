/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;

@Theme("valo")
public class GridSidebarPosition extends AbstractTestUI {

    static final String POPUP_ABOVE = "above";
    static final String POPUP_WINDOW_MOVED_UP = "movedup";
    static final String POPUP_WINDOW_HEIGHT = "windowheight";

    @Override
    protected void setup(VaadinRequest request) {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(true);
        hl.setHeight("100%");
        setContent(hl);
        Grid grid = new Grid("Popup window height");
        grid.setId(POPUP_WINDOW_HEIGHT);
        grid.setWidth("100px");
        for (int i = 0; i < 30; i++) {
            grid.addColumn(
                    "This is a really really really really long column name "
                            + i)
                    .setHidable(true);
        }
        hl.addComponent(grid);

        grid = new Grid("Popup moved up");
        grid.setId(POPUP_WINDOW_MOVED_UP);
        grid.setWidth("100px");
        grid.setHeight("400px");
        for (int i = 0; i < 15; i++) {
            grid.addColumn("Column " + i).setHidable(true);
        }
        hl.addComponent(grid);
        hl.setComponentAlignment(grid, Alignment.BOTTOM_LEFT);

        grid = new Grid("Popup above");
        grid.setId(POPUP_ABOVE);
        grid.setWidth("100px");
        grid.setHeight("200px");
        for (int i = 0; i < 10; i++) {
            grid.addColumn("Column " + i).setHidable(true);
        }
        hl.addComponent(grid);
        hl.setComponentAlignment(grid, Alignment.BOTTOM_LEFT);
    }

}
