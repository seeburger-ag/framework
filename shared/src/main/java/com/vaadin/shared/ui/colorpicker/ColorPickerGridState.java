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

/**
 * Default shared state implementation for ColorPickerGrid.
 *
 * @since 7.0.0
 */
public class ColorPickerGridState extends AbstractComponentState {

    public int rowCount;

    public int columnCount;

    public String[] changedX;

    public String[] changedY;

    public String[] changedColor;

}
