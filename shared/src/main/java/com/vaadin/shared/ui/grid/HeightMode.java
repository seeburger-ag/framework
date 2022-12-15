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
 * The modes for height calculation that are supported by Grid (
 * {@link com.vaadin.client.ui.grid.Grid client} and
 * {@link com.vaadin.ui.components.grid.Grid server}) /
 * {@link com.vaadin.client.ui.grid.Escalator Escalator}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 * @see com.vaadin.client.ui.grid.Grid#setHeightMode(HeightMode)
 * @see com.vaadin.ui.components.grid.Grid#setHeightMode(HeightMode)
 * @see com.vaadin.client.ui.grid.Escalator#setHeightMode(HeightMode)
 */
public enum HeightMode {
    /**
     * The height of the Component or Widget is defined by a CSS-like value.
     * (e.g. "100px", "50em" or "25%")
     */
    CSS,

    /**
     * The height of the Component or Widget in question is defined by a number
     * of rows.
     */
    ROW,

    /**
     * The height of the Component or Widget in question is defined by its
     * contents.
     */
    UNDEFINED;
}
