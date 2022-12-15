/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.draganddropwrapper;

import com.vaadin.shared.communication.ServerRpc;

/**
 * RPC interface for calls from client to server.
 *
 * @since 7.6.4
 * @author Vaadin Ltd
 */
public interface DragAndDropWrapperServerRpc extends ServerRpc {

    /**
     * Called to poll the server to see if any changes have been made e.g. when
     * the upload is complete.
     */
    public void poll();

}
