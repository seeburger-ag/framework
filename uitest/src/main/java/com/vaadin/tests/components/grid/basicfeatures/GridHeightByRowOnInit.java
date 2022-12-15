/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.Container;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@Title("Server Grid height by row on init")
@Theme(ValoTheme.THEME_NAME)
public class GridHeightByRowOnInit extends UI {

    private static final String PROPERTY = "Property";

    @Override
    protected void init(VaadinRequest request) {
        final Grid grid = new Grid();
        Container.Indexed container = grid.getContainerDataSource();
        container.addContainerProperty(PROPERTY, String.class, "");

        container.addItem("A").getItemProperty(PROPERTY).setValue("A");
        container.addItem("B").getItemProperty(PROPERTY).setValue("B");
        container.addItem("C").getItemProperty(PROPERTY).setValue("C");
        container.addItem("D").getItemProperty(PROPERTY).setValue("D");
        container.addItem("E").getItemProperty(PROPERTY).setValue("E");

        grid.setHeightMode(HeightMode.ROW);
        grid.setHeightByRows(5);

        setContent(grid);
    }
}
