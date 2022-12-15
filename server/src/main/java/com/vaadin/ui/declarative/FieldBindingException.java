/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.declarative;

/**
 * Exception that is thrown when an error occurs during field binding when
 * reading a design template
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class FieldBindingException extends RuntimeException {

    public FieldBindingException(String message) {
        super(message);
    }

    public FieldBindingException(String message, Throwable cause) {
        super(message, cause);
    }
}
