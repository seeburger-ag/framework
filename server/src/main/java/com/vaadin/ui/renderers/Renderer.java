/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.renderers;

import com.vaadin.server.ClientConnector;
import com.vaadin.server.Extension;

import elemental.json.JsonValue;

/**
 * A ClientConnector for controlling client-side
 * {@link com.vaadin.client.widget.grid.Renderer Grid renderers}. Renderers
 * currently extend the Extension interface, but this fact should be regarded as
 * an implementation detail and subject to change in a future major or minor
 * Vaadin revision.
 *
 * @param <T>
 *            the type this renderer knows how to present
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface Renderer<T> extends Extension {

    /**
     * Returns the class literal corresponding to the presentation type T.
     *
     * @return the class literal of T
     */
    Class<T> getPresentationType();

    /**
     * Encodes the given value into a {@link JsonValue}.
     *
     * @param value
     *            the value to encode
     * @return a JSON representation of the given value
     */
    JsonValue encode(T value);

    /**
     * This method is inherited from Extension but should never be called
     * directly with a Renderer.
     */
    @Override
    @Deprecated
    void remove();

    /**
     * This method is inherited from Extension but should never be called
     * directly with a Renderer.
     */
    @Override
    @Deprecated
    void setParent(ClientConnector parent);
}
