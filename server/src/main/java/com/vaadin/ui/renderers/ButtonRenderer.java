/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.renderers;

import elemental.json.JsonValue;

/**
 * A Renderer that displays a button with a textual caption. The value of the
 * corresponding property is used as the caption. Click listeners can be added
 * to the renderer, invoked when any of the rendered buttons is clicked.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class ButtonRenderer extends ClickableRenderer<String> {

    /**
     * Creates a new button renderer.
     *
     * @param nullRepresentation
     *            the textual representation of {@code null} value
     */
    public ButtonRenderer(String nullRepresentation) {
        super(String.class, nullRepresentation);
    }

    /**
     * Creates a new button renderer and adds the given click listener to it.
     *
     * @param listener
     *            the click listener to register
     * @param nullRepresentation
     *            the textual representation of {@code null} value
     */
    public ButtonRenderer(RendererClickListener listener,
            String nullRepresentation) {
        this(nullRepresentation);
        addClickListener(listener);
    }

    /**
     * Creates a new button renderer.
     */
    public ButtonRenderer() {
        this("");
    }

    /**
     * Creates a new button renderer and adds the given click listener to it.
     *
     * @param listener
     *            the click listener to register
     */
    public ButtonRenderer(RendererClickListener listener) {
        this(listener, "");
    }

    @Override
    public String getNullRepresentation() {
        return super.getNullRepresentation();
    }

}
