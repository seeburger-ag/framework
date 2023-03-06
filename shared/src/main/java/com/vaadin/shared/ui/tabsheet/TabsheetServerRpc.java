/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.tabsheet;

import com.vaadin.shared.communication.ServerRpc;

/**
 * Client to server RPC methods for the TabSheet.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public interface TabsheetServerRpc extends ServerRpc {

    /**
     * Tell server that a tab has been selected by the user.
     *
     * @param key
     *            internal key of the tab
     */
    void setSelected(String key);

    /**
     * Tell server that a tab has been closed by the user.
     *
     * @param key
     *            internal key of the tab
     */
    void closeTab(String key);

}
