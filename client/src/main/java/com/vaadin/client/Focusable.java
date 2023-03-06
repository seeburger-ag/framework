/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

/**
 * GWT's HasFocus is way too overkill for just receiving focus in simple
 * components. Vaadin uses this interface in addition to GWT's HasFocus to pass
 * focus requests from server to actual ui widgets in browsers.
 *
 * So in to make your server side focusable component receive focus on client
 * side it must either implement this or HasFocus interface.
 */
public interface Focusable {
    /**
     * Sets focus to this widget.
     */
    public void focus();
}
