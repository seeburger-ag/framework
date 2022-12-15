/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import com.google.web.bindery.event.shared.HandlerRegistration;
import com.vaadin.client.renderers.ButtonRenderer;
import com.vaadin.client.renderers.ClickableRenderer.RendererClickHandler;
import com.vaadin.shared.ui.Connect;

import elemental.json.JsonObject;

/**
 * A connector for {@link ButtonRenderer}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(com.vaadin.ui.renderers.ButtonRenderer.class)
public class ButtonRendererConnector
        extends ClickableRendererConnector<String> {

    @Override
    public ButtonRenderer getRenderer() {
        return (ButtonRenderer) super.getRenderer();
    }

    @Override
    protected HandlerRegistration addClickHandler(
            RendererClickHandler<JsonObject> handler) {
        return getRenderer().addClickHandler(handler);
    }
}
