/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.window;

/**
 * Determines the mode of the Window.
 * <p>
 * A window mode decides the size and position of the Window. It can be set to
 * {@link #NORMAL} or {@link #MAXIMIZED}.
 *
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public enum WindowMode {
    /**
     * Normal mode. The window size and position is determined by the window
     * state.
     */
    NORMAL,
    /**
     * Maximized mode. The window is positioned in the top left corner and fills
     * the whole screen.
     */
    MAXIMIZED;
}
