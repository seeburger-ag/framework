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
import com.vaadin.client.widgets.Grid.AbstractGridKeyEvent;

/**
 * Base interface of all handlers for {@link AbstractGridKeyEvent}s.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public abstract interface AbstractGridKeyEventHandler extends EventHandler {

    public abstract interface GridKeyDownHandler
            extends AbstractGridKeyEventHandler {
        public void onKeyDown(GridKeyDownEvent event);
    }

    public abstract interface GridKeyUpHandler
            extends AbstractGridKeyEventHandler {
        public void onKeyUp(GridKeyUpEvent event);
    }

    public abstract interface GridKeyPressHandler
            extends AbstractGridKeyEventHandler {
        public void onKeyPress(GridKeyPressEvent event);
    }

}
