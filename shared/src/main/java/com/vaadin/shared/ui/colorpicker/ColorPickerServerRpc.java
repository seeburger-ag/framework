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
 * RPC interface for AbstractColorPicker.
 *
 * @since 7.0.0
 *
 */
public interface ColorPickerServerRpc extends ServerRpc {

    /**
     * ColorPicker click event.
     *
     * @param openPopup
     *
     */
    public void openPopup(boolean openPopup);

}
