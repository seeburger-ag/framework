/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.data;

import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.annotations.NoLoadingIndicator;
import com.vaadin.shared.communication.ServerRpc;

import elemental.json.JsonArray;

/**
 * RPC interface used for requesting container data to the client.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface DataRequestRpc extends ServerRpc {

    /**
     * Request rows from the server.
     *
     * @param firstRowIndex
     *            the index of the first requested row
     * @param numberOfRows
     *            the number of requested rows
     * @param firstCachedRowIndex
     *            the index of the first cached row
     * @param cacheSize
     *            the number of cached rows
     */
    @NoLoadingIndicator
    public void requestRows(int firstRowIndex, int numberOfRows,
            int firstCachedRowIndex, int cacheSize);

    /**
     * Informs the server that items have been dropped from the client cache.
     *
     * @since 7.6
     * @param rowKeys
     *            array of dropped keys mapping to items
     */
    @Delayed
    @NoLoadingIndicator
    public void dropRows(JsonArray rowKeys);
}
