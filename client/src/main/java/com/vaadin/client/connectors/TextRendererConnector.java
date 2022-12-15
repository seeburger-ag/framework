/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import com.vaadin.client.renderers.TextRenderer;
import com.vaadin.shared.ui.Connect;

/**
 * A connector for {@link TextRenderer}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(com.vaadin.ui.renderers.TextRenderer.class)
public class TextRendererConnector extends AbstractRendererConnector<String> {

    @Override
    public TextRenderer getRenderer() {
        return (TextRenderer) super.getRenderer();
    }
}
