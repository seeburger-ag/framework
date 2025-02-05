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

/**
 * RequestHandler which takes care of locking and unlocking of the VaadinSession
 * automatically. The session is locked before
 * {@link #synchronizedHandleRequest(VaadinSession, VaadinRequest, VaadinResponse)}
 * is called and unlocked after it has completed.
 *
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.1
 */
public abstract class SynchronizedRequestHandler implements RequestHandler {

    @Override
    public boolean handleRequest(VaadinSession session, VaadinRequest request,
            VaadinResponse response) throws IOException {
        if (!canHandleRequest(request)) {
            return false;
        }

        session.lock();
        try {
            return synchronizedHandleRequest(session, request, response);
        } finally {
            session.unlock();
        }
    }

    /**
     * Identical to
     * {@link #handleRequest(VaadinSession, VaadinRequest, VaadinResponse)}
     * except the {@link VaadinSession} is locked before this is called and
     * unlocked after this has completed.
     *
     * @see #handleRequest(VaadinSession, VaadinRequest, VaadinResponse)
     * @param session
     *            The session for the request
     * @param request
     *            The request to handle
     * @param response
     *            The response object to which a response can be written.
     * @return true if a response has been written and no further request
     *         handlers should be called, otherwise false
     *
     * @throws IOException
     *             If an IO error occurred
     */
    public abstract boolean synchronizedHandleRequest(VaadinSession session,
            VaadinRequest request, VaadinResponse response) throws IOException;

    /**
     * Check whether a request may be handled by this handler. This can be used
     * as an optimization to avoid locking the session just to investigate some
     * method property. The default implementation just returns
     * <code>true</code> which means that all requests will be handled by
     * calling
     * {@link #synchronizedHandleRequest(VaadinSession, VaadinRequest, VaadinResponse)}
     * with the session locked.
     *
     * @since 7.2
     * @param request
     *            the request to handle
     * @return <code>true</code> if the request handling should continue once
     *         the session has been locked; <code>false</code> if there's no
     *         need to lock the session since the request would still not be
     *         handled.
     */
    protected boolean canHandleRequest(VaadinRequest request) {
        return true;
    }

}
