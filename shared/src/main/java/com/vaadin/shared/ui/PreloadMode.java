/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui;

/**
 * Enumeration that provides a hint to the browser how media should be
 * preloaded.
 *
 * @since 7.7.11
 */
public enum PreloadMode {
    /**
     * Indicates that the whole video/audio file could be downloaded, even if
     * the user is not expected to use it. This is the default value.
     */
    AUTO,

    /**
     * Indicates that only media metadata (e.g. length) should be preloaded.
     */
    METADATA,

    /**
     * Indicates that the video/audio should not be preloaded.
     */
    NONE;

    /**
     * Returns the preload mode string used by the browser.
     * 
     * @return corresponding preload attribute value string
     */
    public String getValue() {
        return name().toLowerCase();
    }
}
