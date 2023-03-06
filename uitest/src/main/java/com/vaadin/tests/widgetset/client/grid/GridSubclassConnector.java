/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.grid;

import com.vaadin.client.connectors.GridConnector;
import com.vaadin.client.widgets.Grid;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.components.grid.GridSubclass;

import elemental.json.JsonObject;

@Connect(GridSubclass.class)
public class GridSubclassConnector extends GridConnector {

    public static class GridSubclass extends Grid<JsonObject> {

    }

    @Override
    public GridSubclass getWidget() {
        return (GridSubclass) super.getWidget();
    }
}
