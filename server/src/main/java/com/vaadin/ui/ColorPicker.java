/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import com.vaadin.shared.ui.colorpicker.Color;

/**
 * A class that defines default (button-like) implementation for a color picker
 * component.
 *
 * @since 7.0.0
 *
 * @see ColorPickerArea
 *
 */
public class ColorPicker extends AbstractColorPicker {

    /**
     * Instantiates a new color picker.
     */
    public ColorPicker() {
        super();
    }

    /**
     * Instantiates a new color picker.
     *
     * @param popupCaption
     *            caption of the color select popup
     */
    public ColorPicker(String popupCaption) {
        super(popupCaption);
    }

    /**
     * Instantiates a new color picker.
     *
     * @param popupCaption
     *            caption of the color select popup
     * @param initialColor
     *            the initial color
     */
    public ColorPicker(String popupCaption, Color initialColor) {
        super(popupCaption, initialColor);
        setDefaultCaptionEnabled(true);
    }

    @Override
    protected void setDefaultStyles() {
        setPrimaryStyleName(STYLENAME_BUTTON);
        addStyleName(STYLENAME_DEFAULT);
    }

}
