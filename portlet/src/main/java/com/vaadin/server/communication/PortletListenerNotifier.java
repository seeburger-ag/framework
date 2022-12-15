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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.vaadin.server.ServletPortletHelper;
import com.vaadin.server.SynchronizedRequestHandler;
import com.vaadin.server.VaadinPortletRequest;
import com.vaadin.server.VaadinPortletResponse;
import com.vaadin.server.VaadinPortletSession;
import com.vaadin.server.VaadinPortletSession.PortletListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

/**
 * Notifies {@link PortletListener}s of a received portlet request.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public class PortletListenerNotifier extends SynchronizedRequestHandler {

    /**
     * Fires portlet request events to any {@link PortletListener}s registered
     * to the given session using
     * {@link VaadinPortletSession#addPortletListener(PortletListener)}. The
     * PortletListener method corresponding to the request type is invoked.
     */
    @Override
    public boolean synchronizedHandleRequest(VaadinSession session,
            VaadinRequest request, VaadinResponse response) throws IOException {

        VaadinPortletSession sess = (VaadinPortletSession) session;
        PortletRequest portletRequest = ((VaadinPortletRequest) request)
                .getPortletRequest();
        PortletResponse portletResponse = ((VaadinPortletResponse) response)
                .getPortletResponse();

        // Finds the right UI
        UI uI = null;
        if (ServletPortletHelper.isUIDLRequest(request)) {
            uI = session.getService().findUI(request);
        }

        if (portletRequest instanceof RenderRequest) {
            sess.firePortletRenderRequest(uI, (RenderRequest) portletRequest,
                    (RenderResponse) portletResponse);
        } else if (portletRequest instanceof ActionRequest) {
            sess.firePortletActionRequest(uI, (ActionRequest) portletRequest,
                    (ActionResponse) portletResponse);
        } else if (portletRequest instanceof EventRequest) {
            sess.firePortletEventRequest(uI, (EventRequest) portletRequest,
                    (EventResponse) portletResponse);
        } else if (portletRequest instanceof ResourceRequest) {
            sess.firePortletResourceRequest(uI,
                    (ResourceRequest) portletRequest,
                    (ResourceResponse) portletResponse);
        }

        return false;
    }
}
