/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import com.vaadin.shared.ui.Connect;

/**
 * A connector for {@link com.vaadin.ui.components.grid.renderers.NumberRenderer
 * NumberRenderer} .
 * <p>
 * The server-side Renderer operates on numbers, but the data is serialized as a
 * string, and displayed as-is on the client side. This is to be able to support
 * the server's locale.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(com.vaadin.ui.renderers.NumberRenderer.class)
public class NumberRendererConnector extends TextRendererConnector {
    // no implementation needed
}
