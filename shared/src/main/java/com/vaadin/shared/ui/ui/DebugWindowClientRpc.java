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
 * Client RPC methods for the Debug Window.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public interface DebugWindowClientRpc extends ClientRpc {

    /**
     * Send results from {@link DebugWindowServerRpc#analyzeLayouts()} back to
     * the client.
     *
     * @since 7.1
     * @param json
     *            JSON containing list of found problems
     */
    public void reportLayoutProblems(String json);

}
