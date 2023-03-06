/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import java.io.IOException;

import javax.portlet.PortletResponse;
import javax.portlet.StateAwareResponse;

import com.vaadin.server.RequestHandler;
import com.vaadin.server.VaadinPortletResponse;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinSession;

/**
 * Handler which ensures that Action and Event requests are marked as handled
 * and do not cause a 404 to be sent.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public class PortletStateAwareRequestHandler implements RequestHandler {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.server.RequestHandler#handleRequest(com.vaadin.server.
     * VaadinSession, com.vaadin.server.VaadinRequest,
     * com.vaadin.server.VaadinResponse)
     */
    @Override
    public boolean handleRequest(VaadinSession session, VaadinRequest request,
            VaadinResponse response) throws IOException {
        if (!(response instanceof VaadinPortletResponse)) {
            return false;
        }
        PortletResponse portletResponse = ((VaadinPortletResponse) response)
                .getPortletResponse();
        if (portletResponse instanceof StateAwareResponse) {
            // StateAwareResponse is fully handled by listeners through
            // PortletListenerNotifier
            return true;
        }
        return false;
    }

}
