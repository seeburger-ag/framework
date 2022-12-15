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
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.renderers.ClickableRenderer;
import com.vaadin.client.renderers.ClickableRenderer.RendererClickEvent;
import com.vaadin.client.renderers.ClickableRenderer.RendererClickHandler;
import com.vaadin.shared.ui.grid.renderers.RendererClickRpc;

import elemental.json.JsonObject;

/**
 * An abstract base class for {@link ClickableRenderer} connectors.
 *
 * @param <T>
 *            the presentation type of the renderer
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public abstract class ClickableRendererConnector<T>
        extends AbstractRendererConnector<T> {

    HandlerRegistration clickRegistration;

    @Override
    protected void init() {
        clickRegistration = addClickHandler(
                new RendererClickHandler<JsonObject>() {
                    @Override
                    public void onClick(RendererClickEvent<JsonObject> event) {
                        getRpcProxy(RendererClickRpc.class).click(
                                getRowKey(event.getCell().getRow()),
                                getColumnId(event.getCell().getColumn()),
                                MouseEventDetailsBuilder.buildMouseEventDetails(
                                        event.getNativeEvent()));
                    }
                });
    }

    @Override
    public void onUnregister() {
        clickRegistration.removeHandler();
    }

    protected abstract HandlerRegistration addClickHandler(
            RendererClickHandler<JsonObject> handler);
}
