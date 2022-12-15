/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import java.util.Collection;

import com.vaadin.client.data.DataSource.RowHandle;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.widget.grid.selection.SelectionModel;
import com.vaadin.client.widgets.Grid;
import com.vaadin.shared.ui.grid.GridState;

import elemental.json.JsonObject;

/**
 * Base class for all selection model connectors.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public abstract class AbstractSelectionModelConnector<T extends SelectionModel<JsonObject>>
        extends AbstractExtensionConnector {

    @Override
    public GridConnector getParent() {
        return (GridConnector) super.getParent();
    }

    protected Grid<JsonObject> getGrid() {
        return getParent().getWidget();
    }

    protected RowHandle<JsonObject> getRowHandle(JsonObject row) {
        return getGrid().getDataSource().getHandle(row);
    }

    protected String getRowKey(JsonObject row) {
        return row != null ? getParent().getRowKey(row) : null;
    }

    protected abstract T createSelectionModel();

    public abstract static class AbstractSelectionModel
            implements SelectionModel<JsonObject> {

        @Override
        public boolean isSelected(JsonObject row) {
            return row.hasKey(GridState.JSONKEY_SELECTED);
        }

        @Override
        public void setGrid(Grid<JsonObject> grid) {
            // NO-OP
        }

        @Override
        public void reset() {
            // Should not need any actions.
        }

        @Override
        public Collection<JsonObject> getSelectedRows() {
            throw new UnsupportedOperationException(
                    "This client-side selection model "
                            + getClass().getSimpleName()
                            + " does not know selected rows.");
        }
    }
}
