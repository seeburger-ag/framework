/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid;

/**
 * Collection of modes used for resizing columns in the Grid.
 * 
 * @since 7.7.5
 */
public enum ColumnResizeMode {

    /**
     * When column resize mode is set to Animated, columns are resized as they
     * are dragged.
     */
    ANIMATED,

    /**
     * When column resize mode is set to Simple, dragging to resize a column
     * will show a marker, and the column will resize only after the mouse
     * button or touch is released.
     */
    SIMPLE

}
