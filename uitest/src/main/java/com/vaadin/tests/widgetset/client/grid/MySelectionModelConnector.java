/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.grid;

import com.vaadin.client.ServerConnector;
import com.vaadin.client.connectors.MultiSelectionModelConnector;
import com.vaadin.client.renderers.ComplexRenderer;
import com.vaadin.client.widget.grid.selection.ClickSelectHandler;
import com.vaadin.client.widget.grid.selection.SelectionModel.Multi;
import com.vaadin.client.widgets.Grid;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.components.grid.GridCustomSelectionModel.MySelectionModel;

import elemental.json.JsonObject;

@Connect(MySelectionModel.class)
public class MySelectionModelConnector extends MultiSelectionModelConnector {

    private ClickSelectHandler<JsonObject> handler;

    @Override
    protected void extend(ServerConnector target) {
        super.extend(target);
        handler = new ClickSelectHandler<JsonObject>(getGrid());
    }

    @Override
    public void onUnregister() {
        super.onUnregister();
        handler.removeHandler();
        handler = null;
    }

    @Override
    protected Multi<JsonObject> createSelectionModel() {
        return new MySelectionModel();
    }

    public class MySelectionModel extends MultiSelectionModel {

        @Override
        protected ComplexRenderer<Boolean> createSelectionColumnRenderer(
                Grid<JsonObject> grid) {
            // No Selection Column.
            return null;
        }
    }
}
