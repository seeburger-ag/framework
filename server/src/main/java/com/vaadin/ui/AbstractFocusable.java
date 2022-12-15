/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.BlurNotifier;
import com.vaadin.event.FieldEvents.FocusAndBlurServerRpcImpl;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.event.FieldEvents.FocusNotifier;
import com.vaadin.shared.ui.TabIndexState;
import com.vaadin.ui.Component.Focusable;

/**
 * An abstract base class for focusable components. Includes API for setting the
 * tab index, programmatic focusing, and adding focus and blur listeners.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public abstract class AbstractFocusable extends AbstractComponent
        implements Focusable, FocusNotifier, BlurNotifier {

    protected AbstractFocusable() {
        registerRpc(new FocusAndBlurServerRpcImpl(this) {
            @Override
            protected void fireEvent(Event event) {
                AbstractFocusable.this.fireEvent(event);
            }
        });
    }

    @Override
    public void addBlurListener(BlurListener listener) {
        addListener(BlurEvent.EVENT_ID, BlurEvent.class, listener,
                BlurListener.blurMethod);
    }

    /**
     * @deprecated As of 7.0, replaced by {@link #addBlurListener(BlurListener)}
     */
    @Override
    @Deprecated
    public void addListener(BlurListener listener) {
        addBlurListener(listener);
    }

    @Override
    public void removeBlurListener(BlurListener listener) {
        removeListener(BlurEvent.EVENT_ID, BlurEvent.class, listener);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #removeBlurListener(BlurListener)}
     */
    @Override
    @Deprecated
    public void removeListener(BlurListener listener) {
        removeBlurListener(listener);

    }

    @Override
    public void addFocusListener(FocusListener listener) {
        addListener(FocusEvent.EVENT_ID, FocusEvent.class, listener,
                FocusListener.focusMethod);

    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #addFocusListener(FocusListener)}
     */
    @Override
    @Deprecated
    public void addListener(FocusListener listener) {
        addFocusListener(listener);
    }

    @Override
    public void removeFocusListener(FocusListener listener) {
        removeListener(FocusEvent.EVENT_ID, FocusEvent.class, listener);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #removeFocusListener(FocusListener)}
     */
    @Override
    @Deprecated
    public void removeListener(FocusListener listener) {
        removeFocusListener(listener);
    }

    @Override
    public void focus() {
        super.focus();
    }

    @Override
    public int getTabIndex() {
        return getState(false).tabIndex;
    }

    @Override
    public void setTabIndex(int tabIndex) {
        getState().tabIndex = tabIndex;
    }

    @Override
    protected TabIndexState getState() {
        return (TabIndexState) super.getState();
    }

    @Override
    protected TabIndexState getState(boolean markAsDirty) {
        return (TabIndexState) super.getState(markAsDirty);
    }
}
