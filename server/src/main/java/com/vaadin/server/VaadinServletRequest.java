/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * Wrapper for {@link HttpServletRequest}.
 *
 * @author Vaadin Ltd.
 * @since 7.0
 *
 * @see VaadinRequest
 * @see VaadinServletResponse
 */
public class VaadinServletRequest extends HttpServletRequestWrapper
        implements VaadinRequest {

    private final VaadinServletService vaadinService;

    /**
     * Wraps a http servlet request and associates with a vaadin service
     *
     * @param request
     *            the http servlet request to wrap
     * @param vaadinService
     *            the associated vaadin service
     */
    public VaadinServletRequest(HttpServletRequest request,
            VaadinServletService vaadinService) {
        super(request);
        this.vaadinService = vaadinService;
    }

    @Override
    public WrappedSession getWrappedSession() {
        return getWrappedSession(true);
    }

    @Override
    public WrappedSession getWrappedSession(boolean allowSessionCreation) {
        HttpSession session = getSession(allowSessionCreation);
        if (session != null) {
            return new WrappedHttpSession(session);
        } else {
            return null;
        }
    }

    /**
     * Gets the original, unwrapped HTTP servlet request.
     *
     * @return the servlet request
     */
    public HttpServletRequest getHttpServletRequest() {
        return this;
    }

    @Override
    public VaadinServletService getService() {
        return vaadinService;
    }
}
