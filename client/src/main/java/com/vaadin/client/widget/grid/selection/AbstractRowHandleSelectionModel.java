/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.selection;

import com.vaadin.client.data.DataSource.RowHandle;

/**
 * An abstract class that adds a consistent API for common methods that's needed
 * by Vaadin's server-based selection models to work.
 * <p>
 * <em>Note:</em> This should be an interface instead of an abstract class, if
 * only we could define protected methods in an interface.
 *
 * @author Vaadin Ltd
 * @param <T>
 *            The grid's row type
 * @since 7.4
 */
public abstract class AbstractRowHandleSelectionModel<T>
        implements SelectionModel<T> {
    /**
     * Select a row, based on its
     * {@link com.vaadin.client.data.DataSource.RowHandle RowHandle}.
     * <p>
     * <em>Note:</em> this method may not fire selection change events.
     *
     * @param handle
     *            the handle to select by
     * @return <code>true</code> iff the selection state was changed by this
     *         call
     * @throws UnsupportedOperationException
     *             if the selection model does not support either handles or
     *             selection
     */
    protected abstract boolean selectByHandle(RowHandle<T> handle);

    /**
     * Deselect a row, based on its
     * {@link com.vaadin.client.data.DataSource.RowHandle RowHandle}.
     * <p>
     * <em>Note:</em> this method may not fire selection change events.
     *
     * @param handle
     *            the handle to deselect by
     * @return <code>true</code> iff the selection state was changed by this
     *         call
     * @throws UnsupportedOperationException
     *             if the selection model does not support either handles or
     *             deselection
     */
    protected abstract boolean deselectByHandle(RowHandle<T> handle)
            throws UnsupportedOperationException;
}
