/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.tree;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

/**
 * Client-to-server RPC interface for the Tree component
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface TreeServerRpc extends ServerRpc {

    /**
     * Informs the server that a context click happened inside of Tree
     */
    public void contextClick(String rowKey, MouseEventDetails details);

}