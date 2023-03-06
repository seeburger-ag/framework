/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid.selection;

import com.vaadin.shared.communication.ServerRpc;

/**
 * ServerRpc for SingleSelectionModel.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface SingleSelectionModelServerRpc extends ServerRpc {

    /**
     * Selects a row on server-side.
     *
     * @param rowKey
     *            row key of selected row; {@code null} if deselect
     */
    public void select(String rowKey);
}
