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
 * A specialized RequestHandler which is capable of sending session expiration
 * messages to the user.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public interface SessionExpiredHandler extends RequestHandler {

    /**
     * Called when the a session expiration has occured and a notification needs
     * to be sent to the user. If a response is written, this method should
     * return <code>true</code> to indicate that no more
     * {@link SessionExpiredHandler} handlers should be invoked for the request.
     *
     * @param request
     *            The request to handle
     * @param response
     *            The response object to which a response can be written.
     * @return true if a response has been written and no further request
     *         handlers should be called, otherwise false
     * @throws IOException
     *             If an IO error occurred
     * @since 7.1
     */
    boolean handleSessionExpired(VaadinRequest request, VaadinResponse response)
            throws IOException;

}
