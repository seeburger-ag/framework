/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.colorpicker;

import com.vaadin.shared.communication.ServerRpc;

/**
 * RPC interface for ColorPickerGrid.
 *
 * @since 7.0.0
 *
 */
public interface ColorPickerGridServerRpc extends ServerRpc {

    /**
     * ColorPickerGrid click event.
     *
     * @param x
     * @param y
     */
    public void select(int x, int y);

    /**
     * Call to refresh the grid.
     */
    public void refresh();

}
