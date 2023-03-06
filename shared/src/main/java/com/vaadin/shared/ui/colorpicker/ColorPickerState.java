/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.colorpicker;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.DelegateToWidget;

/**
 * Default shared state implementation for AbstractColorPicker.
 *
 * @since 7.0.0
 */
public class ColorPickerState extends AbstractComponentState {
    {
        primaryStyleName = "v-colorpicker";
    }

    @DelegateToWidget("setOpen")
    public boolean popupVisible = false;

    @DelegateToWidget("setColor")
    public String color = null;

    public boolean showDefaultCaption;

}
