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
import com.vaadin.client.communication.JsonDecoder;
import com.vaadin.client.metadata.TypeDataStore;
import com.vaadin.client.renderers.ClickableRenderer.RendererClickHandler;
import com.vaadin.client.renderers.ImageRenderer;
import com.vaadin.shared.communication.URLReference;
import com.vaadin.shared.ui.Connect;

import elemental.json.JsonObject;
import elemental.json.JsonValue;

/**
 * A connector for {@link ImageRenderer}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(com.vaadin.ui.renderers.ImageRenderer.class)
public class ImageRendererConnector extends ClickableRendererConnector<String> {

    @Override
    public ImageRenderer getRenderer() {
        return (ImageRenderer) super.getRenderer();
    }

    @Override
    public String decode(JsonValue value) {
        URLReference reference = (URLReference) JsonDecoder.decodeValue(
                TypeDataStore.getType(URLReference.class), value, null,
                getConnection());

        return reference != null ? reference.getURL() : null;
    }

    @Override
    protected HandlerRegistration addClickHandler(
            RendererClickHandler<JsonObject> handler) {
        return getRenderer().addClickHandler(handler);
    }
}
