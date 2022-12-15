/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.client.Focusable;

public class VCustomField extends VCustomComponent implements Focusable {

    private Focusable focusDelegate;

    @Override
    public void focus() {
        if (focusDelegate != null) {
            focusDelegate.focus();
        }
    }

    /**
     * Sets the focusable widget to focus instead of this custom field.
     * 
     * @param focusDelegate
     *            the widget to delegate focus to
     */
    public void setFocusDelegate(Focusable focusDelegate) {
        this.focusDelegate = focusDelegate;

    }

    /**
     * Sets the focusable widget to focus instead of this custom field.
     * 
     * @param focusDelegate
     *            the widget to delegate focus to
     */
    public void setFocusDelegate(
            final com.google.gwt.user.client.ui.Focusable focusDelegate) {
        this.focusDelegate = new Focusable() {
            @Override
            public void focus() {
                focusDelegate.setFocus(true);
            }
        };

    }

}
