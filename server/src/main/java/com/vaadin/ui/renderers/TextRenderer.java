/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.renderers;

import com.vaadin.ui.Grid.AbstractRenderer;
import elemental.json.JsonValue;

/**
 * A renderer for presenting simple plain-text string values.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class TextRenderer extends AbstractRenderer<String> {

    /**
     * Creates a new text renderer
     */
    public TextRenderer() {
        this("");
    }

    /**
     * Creates a new text renderer
     *
     * @param nullRepresentation
     *            the textual representation of {@code null} value
     */
    public TextRenderer(String nullRepresentation) {
        super(String.class, nullRepresentation);
    }

    @Override
    public String getNullRepresentation() {
        return super.getNullRepresentation();
    }
}
