/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.selection;

import java.util.Collection;
import java.util.Collections;

import com.vaadin.client.data.DataSource.RowHandle;
import com.vaadin.client.renderers.Renderer;
import com.vaadin.client.widgets.Grid;

/**
 * No-row selection model.
 *
 * @author Vaadin Ltd
 * @since 7.4
 */
public class SelectionModelNone<T> extends AbstractRowHandleSelectionModel<T>
        implements SelectionModel.None<T> {

    @Override
    public boolean isSelected(T row) {
        return false;
    }

    @Override
    public Renderer<Boolean> getSelectionColumnRenderer() {
        return null;
    }

    @Override
    public void setGrid(Grid<T> grid) {
        // noop
    }

    @Override
    public void reset() {
        // noop
    }

    @Override
    public Collection<T> getSelectedRows() {
        return Collections.emptySet();
    }

    @Override
    protected boolean selectByHandle(RowHandle<T> handle)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException(
                "This selection model " + "does not support selection");
    }

    @Override
    protected boolean deselectByHandle(RowHandle<T> handle)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException(
                "This selection model " + "does not support deselection");
    }

}
