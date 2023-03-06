/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.communication;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

import elemental.json.JsonObject;

/**
 * XhrConnectionError provides detail about an error which occured during an XHR
 * request to the server
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public class XhrConnectionError {

    private Throwable exception;
    private Request request;
    private Response response;
    private JsonObject payload;

    /**
     * Constructs an event from the given request, payload and exception
     *
     * @param request
     *            the request which failed
     * @param payload
     *            the payload which was going to the server
     * @param exception
     *            the exception describing the problem
     */
    public XhrConnectionError(Request request, JsonObject payload,
            Throwable exception) {
        this.request = request;
        this.exception = exception;
        this.payload = payload;
    }

    /**
     * Constructs an event from the given request, response and payload
     *
     * @param request
     *            the request which failed
     * @param payload
     *            the payload which was going to the server
     * @param response
     *            the response for the request
     */
    public XhrConnectionError(Request request, JsonObject payload,
            Response response) {
        this.request = request;
        this.response = response;
        this.payload = payload;
    }

    /**
     * Returns the exception which caused the problem, if available
     *
     * @return the exception which caused the problem, or null if not available
     */
    public Throwable getException() {
        return exception;
    }

    /**
     * Returns the request for which the problem occurred
     *
     * @return the request where the problem occurred
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Returns the received response, if available
     *
     * @return the received response, or null if not available
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Returns the payload which was sent to the server
     *
     * @return the payload which was sent, never null
     */
    public JsonObject getPayload() {
        return payload;
    }
}