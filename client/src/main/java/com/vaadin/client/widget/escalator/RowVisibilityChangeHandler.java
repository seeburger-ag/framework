/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.widget.escalator;

import com.google.gwt.event.shared.EventHandler;

/**
 * Event handler that gets notified when the range of visible rows changes e.g.
 * because of scrolling.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface RowVisibilityChangeHandler extends EventHandler {

    /**
     * Called when the range of visible rows changes e.g. because of scrolling.
     *
     * @param event
     *            the row visibility change event describing the change
     */
    void onRowVisibilityChange(RowVisibilityChangeEvent event);

}
