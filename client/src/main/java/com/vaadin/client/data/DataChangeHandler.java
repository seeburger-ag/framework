/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.data;

/**
 * Callback interface used by {@link DataSource} to inform its user about
 * updates to the data.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface DataChangeHandler {
    /**
     * Called when the contents of the data source has changed. If the number of
     * rows has changed or if rows have been moved around,
     * {@link #dataAdded(int, int)} or {@link #dataRemoved(int, int)} should
     * ideally be used instead.
     *
     * @param firstRowIndex
     *            the index of the first changed row
     * @param numberOfRows
     *            the number of changed rows
     */
    public void dataUpdated(int firstRowIndex, int numberOfRows);

    /**
     * Called when rows have been removed from the data source.
     *
     * @param firstRowIndex
     *            the index that the first removed row had prior to removal
     * @param numberOfRows
     *            the number of removed rows
     */
    public void dataRemoved(int firstRowIndex, int numberOfRows);

    /**
     * Called when the new rows have been added to the container.
     *
     * @param firstRowIndex
     *            the index of the first added row
     * @param numberOfRows
     *            the number of added rows
     */
    public void dataAdded(int firstRowIndex, int numberOfRows);

    /**
     * Called when rows requested with
     * {@link DataSource#ensureAvailability(int, int)} rows are available.
     *
     * @param firstRowIndex
     *            the index of the first available row
     * @param numberOfRows
     *            the number of available rows
     */
    public void dataAvailable(int firstRowIndex, int numberOfRows);

    /**
     * Resets all data and defines a new size for the data.
     * <p>
     * This should be used in the cases where the data has changed in some
     * unverifiable way. I.e. "something happened". This will lead to a
     * re-rendering of the current Grid viewport
     *
     * @param estimatedNewDataSize
     *            the estimated size of the new data set
     */
    public void resetDataAndSize(int estimatedNewDataSize);
}
