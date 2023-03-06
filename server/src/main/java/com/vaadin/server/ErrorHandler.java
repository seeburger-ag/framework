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
 * Interface for listening to errors in the application.
 */
public interface ErrorHandler extends Serializable {

    /**
     * Invoked when an error occurs.
     *
     * @param event
     *            the fired event.
     */
    public void error(ErrorEvent event);
}
