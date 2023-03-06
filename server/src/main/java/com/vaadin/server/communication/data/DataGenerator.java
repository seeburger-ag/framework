/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication.data;

import java.io.Serializable;

import com.vaadin.data.Item;
import com.vaadin.ui.Grid.AbstractGridExtension;

import elemental.json.JsonObject;

/**
 * Interface for {@link AbstractGridExtension}s that allows adding data to row
 * objects being sent to client by the {@link RpcDataProviderExtension}.
 * <p>
 * This class also provides a way to remove any unneeded data once the data
 * object is no longer used on the client-side.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface DataGenerator extends Serializable {

    /**
     * Adds data to row object for given item and item id being sent to client.
     *
     * @param itemId
     *            item id of item
     * @param item
     *            item being sent to client
     * @param rowData
     *            row object being sent to client
     */
    public void generateData(Object itemId, Item item, JsonObject rowData);

    /**
     * Informs the DataGenerator that an item id has been dropped and is no
     * longer needed. This method should clean up any unneeded stored data
     * related to the item.
     *
     * @param itemId
     *            removed item id
     */
    public void destroyData(Object itemId);
}
