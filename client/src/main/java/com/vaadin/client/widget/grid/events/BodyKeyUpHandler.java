/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.vaadin.client.widget.grid.events.AbstractGridKeyEventHandler.GridKeyUpHandler;

/**
 * Handler for {@link GridKeyUpEvent}s that happen when the focused cell is in
 * the body of the Grid.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface BodyKeyUpHandler extends GridKeyUpHandler {
}