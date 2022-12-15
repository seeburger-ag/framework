/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

/**
 * Exception thrown if the UI has been detached when it should not be.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public class UIDetachedException extends RuntimeException {

    public UIDetachedException() {
        super();
    }

    public UIDetachedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UIDetachedException(String message) {
        super(message);
    }

    public UIDetachedException(Throwable cause) {
        super(cause);
    }

}
