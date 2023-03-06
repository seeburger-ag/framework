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
 * A renderer for presenting HTML content.
 *
 * @author Vaadin Ltd
 * @since 7.4
 */
public class HtmlRenderer extends AbstractRenderer<String> {
    /**
     * Creates a new HTML renderer.
     *
     * @param nullRepresentation
     *            the html representation of {@code null} value
     */
    public HtmlRenderer(String nullRepresentation) {
        super(String.class, nullRepresentation);
    }

    /**
     * Creates a new HTML renderer.
     */
    public HtmlRenderer() {
        this("");
    }

    @Override
    public String getNullRepresentation() {
        return super.getNullRepresentation();
    }
}
