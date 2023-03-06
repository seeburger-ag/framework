/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.grid;

import com.vaadin.shared.communication.ClientRpc;
import com.vaadin.tests.widgetset.client.grid.GridClientColumnRendererConnector.Renderers;

public interface GridClientColumnRendererRpc extends ClientRpc {

    /**
     * Adds a new column with a specific renderer to the grid
     *
     */
    void addColumn(Renderers renderer);

    /**
     * Detaches and attaches the client side Grid
     */
    void detachAttach();

    /**
     * Used for client-side sorting API test
     */
    void triggerClientSorting();

    /**
     * @since
     */
    void triggerClientSortingTest();

    /**
     * @since
     */
    void shuffle();
}
