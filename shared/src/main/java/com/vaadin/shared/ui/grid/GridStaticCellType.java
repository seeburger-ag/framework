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
 * Enumeration, specifying the content type of a Cell in a GridStaticSection.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public enum GridStaticCellType {
    /**
     * Text content
     */
    TEXT,

    /**
     * HTML content
     */
    HTML,

    /**
     * Widget content
     */
    WIDGET;
}
