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

/**
 * Listener that gets notified when the {@link VaadinService} to which it has
 * been registered is destroyed.
 *
 * @see VaadinService#addServiceDestroyListener(ServiceDestroyListener)
 * @see VaadinService#removeServiceDestroyListener(ServiceDestroyListener)
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public interface ServiceDestroyListener extends Serializable {
    /**
     * Invoked when a service is destroyed
     *
     * @param event
     *            the event
     */
    public void serviceDestroy(ServiceDestroyEvent event);
}
