/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.colorpicker;

import java.io.Serializable;

import com.vaadin.shared.ui.colorpicker.Color;

/**
 * An interface for a color selector.
 *
 * @since 7.0.0
 */
public interface ColorSelector extends Serializable, HasColorChangeListener {

    /**
     * Sets the color.
     *
     * @param color
     *            the new color
     */
    public void setColor(Color color);

    /**
     * Gets the color.
     *
     * @return the color
     */
    public Color getColor();
}
