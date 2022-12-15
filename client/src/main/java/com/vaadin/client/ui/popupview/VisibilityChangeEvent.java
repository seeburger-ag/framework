/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.popupview;

import com.google.gwt.event.shared.GwtEvent;

public class VisibilityChangeEvent extends GwtEvent<VisibilityChangeHandler> {

    private static Type<VisibilityChangeHandler> TYPE;

    private boolean visible;

    public VisibilityChangeEvent(final boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public Type<VisibilityChangeHandler> getAssociatedType() {
        return getType();
    }

    public static Type<VisibilityChangeHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<VisibilityChangeHandler>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(final VisibilityChangeHandler handler) {
        handler.onVisibilityChange(this);
    }
}
