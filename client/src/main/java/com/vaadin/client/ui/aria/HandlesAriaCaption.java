/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.aria;

/**
 * Some Widgets need to handle the caption handling for WAI-ARIA themselfs, as
 * for example the required ids need to be set in a specific way. In such a
 * case, the Widget needs to implement this interface.
 */
public interface HandlesAriaCaption {

    /**
     * Called to bind the provided caption (label in HTML speak) element to the
     * main input element of the Widget.
     *
     * Binding should be removed from the main input field when captionElement
     * is null.
     *
     * @param captionElement
     *            Element of the caption
     */
    void bindAriaCaption(com.google.gwt.user.client.Element captionElement);
}
