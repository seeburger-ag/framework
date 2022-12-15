/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid.selection;

import java.util.List;

import com.vaadin.shared.communication.ServerRpc;

/**
 * ServerRpc for MultiSelectionModel.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface MultiSelectionModelServerRpc extends ServerRpc {

    /**
     * Select a list of rows based on their row keys on the server-side.
     *
     * @param rowKeys
     *            list of row keys to select
     */
    public void select(List<String> rowKeys);

    /**
     * Deselect a list of rows based on their row keys on the server-side.
     *
     * @param rowKeys
     *            list of row keys to deselect
     */
    public void deselect(List<String> rowKeys);

    /**
     * Selects all rows on the server-side.
     */
    public void selectAll();

    /**
     * Deselects all rows on the server-side.
     */
    public void deselectAll();
}
