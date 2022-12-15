/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * A handler that gets called whenever a scrollbar bundle is scrolled
 *
 * @author Vaadin Ltd
 * @since 7.4
 */
public interface ScrollHandler extends EventHandler {
    /**
     * A callback method that is called once a scrollbar bundle has been
     * scrolled.
     *
     * @param event
     *            the scroll event
     */
    public void onScroll(ScrollEvent event);
}
