/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.ui;

import com.vaadin.shared.communication.ClientRpc;

/**
 * Server to Client RPC methods for UI
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public interface UIClientRpc extends ClientRpc {

    /**
     * Informs the client that the UI has been closed
     *
     * @param sessionExpired
     *            true if the ui was closed because the session expired, false
     *            otherwise
     */
    void uiClosed(boolean sessionExpired);

}
