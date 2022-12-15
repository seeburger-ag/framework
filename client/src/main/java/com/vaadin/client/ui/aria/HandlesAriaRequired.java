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
 * Some Widgets need to handle the required handling for WAI-ARIA themselfs, as
 * this attribute needs to be set to the input element itself. In such a case,
 * the Widget needs to implement this interface.
 */
public interface HandlesAriaRequired {
    /**
     * Called to set the element, typically an input element, as required.
     *
     * @param required
     *            boolean true when the element needs to be set as required
     */
    void setAriaRequired(boolean required);
}
