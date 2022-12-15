/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import java.io.Serializable;

import com.vaadin.server.AbstractJavaScriptExtension;

import elemental.json.JsonArray;

/**
 * Defines a method that is called by a client-side JavaScript function. When
 * the corresponding JavaScript function is called, the {@link #call(JsonArray)}
 * method is invoked.
 *
 * @see JavaScript#addFunction(String, JavaScriptFunction)
 * @see AbstractJavaScriptComponent#addFunction(String, JavaScriptFunction)
 * @see AbstractJavaScriptExtension#addFunction(String, JavaScriptFunction)
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public interface JavaScriptFunction extends Serializable {
    /**
     * Invoked whenever the corresponding JavaScript function is called in the
     * browser.
     * <p>
     * Because of the asynchronous nature of the communication between client
     * and server, no return value can be sent back to the browser.
     *
     * @param arguments
     *            an array with JSON representations of the arguments with which
     *            the JavaScript function was called.
     */
    public void call(JsonArray arguments);
}
