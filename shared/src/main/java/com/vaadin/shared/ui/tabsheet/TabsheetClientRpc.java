/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.tabsheet;

import com.vaadin.shared.communication.ClientRpc;

/**
 * Server to client RPC methods for the TabSheet.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public interface TabsheetClientRpc extends ClientRpc {

    /**
     * Forces the client to switch to the tab that is selected by the server.
     *
     * This is required e.g. for reverting tab selection change on the server
     * side (shared state does not change).
     */
    public void revertToSharedStateSelection();
}
