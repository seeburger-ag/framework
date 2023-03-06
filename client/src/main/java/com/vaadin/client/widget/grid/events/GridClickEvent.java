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
import com.vaadin.client.widget.grid.events.AbstractGridMouseEventHandler.GridClickHandler;
import com.vaadin.client.widgets.Grid;
import com.vaadin.client.widgets.Grid.AbstractGridMouseEvent;
import com.vaadin.shared.ui.grid.GridConstants.Section;

/**
 * Represents native mouse click event in Grid.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class GridClickEvent extends AbstractGridMouseEvent<GridClickHandler> {

    /**
     * @since 7.7.9
     */
    public static final Type<GridClickHandler> TYPE = new Type<GridClickHandler>(
            BrowserEvents.CLICK, new GridClickEvent());

    /**
     * @since 7.7.9
     */
    public GridClickEvent() {
    }

    /**
     * @deprecated This constructor's arguments are no longer used. Use the
     *             no-args constructor instead.
     */
    @Deprecated
    public GridClickEvent(Grid<?> grid, CellReference<?> targetCell) {
    }

    /**
     * @since 7.7.9
     */
    @Override
    public Type<GridClickHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected String getBrowserEventType() {
        return BrowserEvents.CLICK;
    }

    @Override
    protected void doDispatch(GridClickHandler handler, Section section) {
        if ((section == Section.BODY && handler instanceof BodyClickHandler)
                || (section == Section.HEADER
                        && handler instanceof HeaderClickHandler)
                || (section == Section.FOOTER
                        && handler instanceof FooterClickHandler)) {
            handler.onClick(this);
        }
    }
}
