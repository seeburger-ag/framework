/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.label;

/**
 * Content modes defining how the client should interpret a Label's value.
 *
 * @since 7.0.0
 */
public enum ContentMode {
    /**
     * Content mode, where the label contains only plain text.
     */
    TEXT,

    /**
     * Content mode, where the label contains preformatted text. In this mode
     * newlines are preserved when rendered on the screen.
     */
    PREFORMATTED,

    /**
     * Content mode, where the label contains HTML.
     */
    HTML,

    /**
     * Content mode, where the label contains well-formed or well-balanced XML.
     * This is handled in the same way as {@link #HTML}.
     *
     * @deprecated Use {@link #HTML} instead
     */
    @Deprecated
    XML,

    /**
     * Legacy content mode, where the label contains RAW output. This is handled
     * in exactly the same way as {@link #HTML}.
     *
     * @deprecated Use {@link #HTML} instead
     */
    @Deprecated
    RAW;
}
