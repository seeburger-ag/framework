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
 * A renderer that represents a double values as a graphical progress bar.
 *
 * @author Vaadin Ltd
 * @since 7.4
 */
public class ProgressBarRenderer extends AbstractRenderer<Double> {

    /**
     * Creates a new text renderer
     */
    public ProgressBarRenderer() {
        super(Double.class, null);
    }

    @Override
    public JsonValue encode(Double value) {
        if (value != null) {
            value = Math.max(Math.min(value, 1), 0);
        } else {
            value = 0d;
        }
        return super.encode(value);
    }
}
