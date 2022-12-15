/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.declarative;

@SuppressWarnings("serial")
/**
 * An exception that is used when reading or writing a design fails.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class DesignException extends RuntimeException {

    public DesignException() {
        super();
    }

    public DesignException(String message) {
        super(message);
    }

    public DesignException(String message, Throwable e) {
        super(message, e);
    }

}