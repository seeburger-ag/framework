/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import com.vaadin.client.ServerConnector;
import com.vaadin.client.widget.grid.selection.SelectionModel;
import com.vaadin.client.widget.grid.selection.SelectionModelNone;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.Grid.NoSelectionModel;

import elemental.json.JsonObject;

/**
 * Connector for server-side {@link NoSelectionModel}.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
@Connect(NoSelectionModel.class)
public class NoSelectionModelConnector
        extends AbstractSelectionModelConnector<SelectionModel<JsonObject>> {

    @Override
    protected void extend(ServerConnector target) {
        getGrid().setSelectionModel(createSelectionModel());
    }

    @Override
    protected SelectionModel<JsonObject> createSelectionModel() {
        return new SelectionModelNone<JsonObject>();
    }
}