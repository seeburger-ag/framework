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
 * Callback for generating a viewport tag content based on a request.
 *
 * @see ViewportGenerator
 *
 * @since 7.4
 *
 * @author Vaadin Ltd
 */
public interface ViewportGenerator extends Serializable {
    /**
     * Generates a viewport tag based on a request.
     *
     * @param request
     *            the request for which to generate a viewport tag
     * @return the viewport tag content
     */
    public String getViewport(VaadinRequest request);
}
