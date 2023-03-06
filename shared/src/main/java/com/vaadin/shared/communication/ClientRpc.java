/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.communication;

import java.io.Serializable;

/**
 * Interface to be extended by all server to client RPC interfaces.
 *
 * On the server side, proxies of the interface can be obtained from
 * AbstractComponent. On the client, RPC implementations can be registered with
 * AbstractConnector.registerRpc().
 *
 * Note: Currently, each RPC interface may not contain multiple methods with the
 * same name, even if their parameter lists would differ.
 *
 * @since 7.0
 */
public interface ClientRpc extends Serializable {

}
