/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.client.widget.grid.selection.SelectionModel;

/**
 * A select all event, fired by the Grid when it needs all rows in data source
 * to be selected.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class SelectAllEvent<T> extends GwtEvent<SelectAllHandler<T>> {

    /**
     * Handler type.
     */
    private final static Type<SelectAllHandler<?>> TYPE = new Type<SelectAllHandler<?>>();;

    private SelectionModel.Multi<T> selectionModel;

    public SelectAllEvent(SelectionModel.Multi<T> selectionModel) {
        this.selectionModel = selectionModel;
    }

    public static final Type<SelectAllHandler<?>> getType() {
        return TYPE;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Type<SelectAllHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(SelectAllHandler<T> handler) {
        handler.onSelectAll(this);
    }

    public SelectionModel.Multi<T> getSelectionModel() {
        return selectionModel;
    }
}
