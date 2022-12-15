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
 * Defines the interface to handle exceptions thrown during the execution of a
 * FutureAccess.
 *
 * @since 7.1.8
 * @author Vaadin Ltd
 */
public interface ErrorHandlingRunnable extends Runnable, Serializable {

    /**
     * Handles exceptions thrown during the execution of a FutureAccess.
     *
     * @since 7.1.8
     * @param exception
     *            the thrown exception.
     */
    public void handleError(Exception exception);

}
