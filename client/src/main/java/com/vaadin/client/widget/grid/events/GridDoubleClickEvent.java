/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.google.gwt.dom.client.BrowserEvents;
import com.vaadin.client.widget.grid.CellReference;
import com.vaadin.client.widget.grid.events.AbstractGridMouseEventHandler.GridDoubleClickHandler;
import com.vaadin.client.widgets.Grid;
import com.vaadin.client.widgets.Grid.AbstractGridMouseEvent;
import com.vaadin.shared.ui.grid.GridConstants.Section;

/**
 * Represents native mouse double click event in Grid.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class GridDoubleClickEvent
        extends AbstractGridMouseEvent<GridDoubleClickHandler> {

    /**
     * @since 7.7.9
     */
    public static final Type<GridDoubleClickHandler> TYPE = new Type<GridDoubleClickHandler>(
            BrowserEvents.DBLCLICK, new GridDoubleClickEvent());

    /**
     * @since 7.7.9
     */
    public GridDoubleClickEvent() {
    }

    /**
     * @deprecated This constructor's arguments are no longer used. Use the
     *             no-args constructor instead.
     */
    @Deprecated
    public GridDoubleClickEvent(Grid<?> grid, CellReference<?> targetCell) {
    }

    /**
     * @since 7.7.9
     */
    @Override
    public Type<GridDoubleClickHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected String getBrowserEventType() {
        return BrowserEvents.DBLCLICK;
    }

    @Override
    protected void doDispatch(GridDoubleClickHandler handler, Section section) {
        if ((section == Section.BODY
                && handler instanceof BodyDoubleClickHandler)
                || (section == Section.HEADER
                        && handler instanceof HeaderDoubleClickHandler)
                || (section == Section.FOOTER
                        && handler instanceof FooterDoubleClickHandler)) {
            handler.onDoubleClick(this);
        }
    }
}
