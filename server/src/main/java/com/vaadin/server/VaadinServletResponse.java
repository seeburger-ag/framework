/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Wrapper for {@link HttpServletResponse}.
 *
 * @author Vaadin Ltd.
 * @since 7.0
 *
 * @see VaadinResponse
 * @see VaadinServletRequest
 */
public class VaadinServletResponse extends HttpServletResponseWrapper
        implements VaadinResponse {

    private VaadinServletService vaadinService;

    /**
     * Wraps a http servlet response and an associated vaadin service
     *
     * @param response
     *            the http servlet response to wrap
     * @param vaadinService
     *            the associated vaadin service
     */
    public VaadinServletResponse(HttpServletResponse response,
            VaadinServletService vaadinService) {
        super(response);
        this.vaadinService = vaadinService;
    }

    /**
     * Gets the original unwrapped <code>HttpServletResponse</code>
     *
     * @return the unwrapped response
     */
    public HttpServletResponse getHttpServletResponse() {
        return this;
    }

    @Override
    public void setCacheTime(long milliseconds) {
        doSetCacheTime(this, milliseconds);
    }

    // Implementation shared with VaadinPortletResponse
    static void doSetCacheTime(VaadinResponse response, long milliseconds) {
        if (milliseconds <= 0) {
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        } else {
            response.setHeader("Cache-Control",
                    "max-age=" + milliseconds / 1000);
            response.setDateHeader("Expires",
                    System.currentTimeMillis() + milliseconds);
            // Required to apply caching in some Tomcats
            response.setHeader("Pragma", "cache");
        }
    }

    @Override
    public VaadinServletService getService() {
        return vaadinService;
    }
}
