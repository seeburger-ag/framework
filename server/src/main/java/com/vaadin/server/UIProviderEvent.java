/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.io.Serializable;
import java.util.EventObject;

/**
 * Base class for the events that are sent to various methods in UIProvider.
 *
 * @see UIProvider
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class UIProviderEvent extends EventObject implements Serializable {

    private final VaadinRequest request;

    /**
     * Creates a new UI provider event.
     *
     * @param request
     *            the request for which the event is UI provider is invoked
     */
    public UIProviderEvent(VaadinRequest request) {
        super(request.getService());
        this.request = request;
    }

    /**
     * Gets the Vaadin service from which the event originates.
     *
     * @return the Vaadin service
     */
    public VaadinService getService() {
        return (VaadinService) getSource();
    }

    /**
     * Gets the request associated with this event.
     *
     * @return the Vaadin request
     */
    public VaadinRequest getRequest() {
        return request;
    }

}
