/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.io.IOException;
import java.io.Serializable;

/**
 * <code>PaintExcepection</code> is thrown if painting of a component fails.
 *
 * @author Vaadin Ltd.
 * @since 3.0
 */
@SuppressWarnings("serial")
public class PaintException extends IOException implements Serializable {

    /**
     * Constructs an instance of <code>PaintExeception</code> with the specified
     * detail message.
     *
     * @param msg
     *            the detail message.
     */
    public PaintException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>PaintExeception</code> with the specified
     * detail message and cause.
     *
     * @param msg
     *            the detail message.
     * @param cause
     *            the cause
     */
    public PaintException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructs an instance of <code>PaintExeception</code> from IOException.
     *
     * @param exception
     *            the original exception.
     */
    public PaintException(IOException exception) {
        super(exception.getMessage());
    }
}
