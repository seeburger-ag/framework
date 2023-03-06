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
import com.vaadin.client.widgets.Grid.AbstractGridMouseEvent;

/**
 * Base interface of all handlers for {@link AbstractGridMouseEvent}s.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public abstract interface AbstractGridMouseEventHandler extends EventHandler {

    public abstract interface GridClickHandler
            extends AbstractGridMouseEventHandler {
        public void onClick(GridClickEvent event);
    }

    public abstract interface GridDoubleClickHandler
            extends AbstractGridMouseEventHandler {
        public void onDoubleClick(GridDoubleClickEvent event);
    }

}