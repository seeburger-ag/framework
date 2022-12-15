/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

/**
 * Contains information used by
 * {@link UIProvider#getUIClass(UIClassSelectionEvent)} to choose a UI class to
 * use in a specific situation.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class UIClassSelectionEvent extends UIProviderEvent {

    /**
     * Creates a new event for a specific request.
     *
     * @param request
     *            the Vaadin request for which a UI class is wanted.
     */
    public UIClassSelectionEvent(VaadinRequest request) {
        super(request);
    }

}
