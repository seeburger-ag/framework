/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.util.EventObject;

/**
 * Event fired to {@link ServiceDestroyListener} when a {@link VaadinService} is
 * being destroyed.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class ServiceDestroyEvent extends EventObject {

    /**
     * Creates a new event for the given service.
     *
     * @param service
     *            the service being destroyed
     */
    public ServiceDestroyEvent(VaadinService service) {
        super(service);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.EventObject#getSource()
     */
    @Override
    public VaadinService getSource() {
        return (VaadinService) super.getSource();
    }

}
