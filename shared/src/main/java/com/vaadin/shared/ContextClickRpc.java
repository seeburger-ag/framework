/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared;

import com.vaadin.shared.communication.ServerRpc;

/**
 * Client-to-server RPC interface for context click events
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface ContextClickRpc extends ServerRpc {

    public void contextClick(MouseEventDetails details);
}
