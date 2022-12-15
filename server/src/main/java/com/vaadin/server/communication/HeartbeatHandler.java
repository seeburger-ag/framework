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

import javax.servlet.http.HttpServletResponse;

import com.vaadin.server.ServletPortletHelper;
import com.vaadin.server.SessionExpiredHandler;
import com.vaadin.server.SynchronizedRequestHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ui.UIConstants;
import com.vaadin.ui.UI;

/**
 * Handles heartbeat requests. Heartbeat requests are periodically sent by the
 * client-side to inform the server that the UI sending the heartbeat is still
 * alive (the browser window is open, the connection is up) even when there are
 * no UIDL requests for a prolonged period of time. UIs that do not receive
 * either heartbeat or UIDL requests are eventually removed from the session and
 * garbage collected.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public class HeartbeatHandler extends SynchronizedRequestHandler
        implements SessionExpiredHandler {

    @Override
    protected boolean canHandleRequest(VaadinRequest request) {
        return ServletPortletHelper.isHeartbeatRequest(request);
    }

    /**
     * Handles a heartbeat request for the given session. Reads the GET
     * parameter named {@link UIConstants#UI_ID_PARAMETER} to identify the UI.
     * If the UI is found in the session, sets it
     * {@link UI#getLastHeartbeatTimestamp() heartbeat timestamp} to the current
     * time. Otherwise, writes a HTTP Not Found error to the response.
     */
    @Override
    public boolean synchronizedHandleRequest(VaadinSession session,
            VaadinRequest request, VaadinResponse response) throws IOException {
        UI ui = session.getService().findUI(request);
        if (ui != null) {
            ui.setLastHeartbeatTimestamp(System.currentTimeMillis());
            // Ensure that the browser does not cache heartbeat responses.
            // iOS 6 Safari requires this (#10370)
            response.setHeader("Cache-Control", "no-cache");
            // If Content-Type is not set, browsers assume text/html and may
            // complain about the empty response body (#12182)
            response.setHeader("Content-Type", "text/plain");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "UI not found");
        }

        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.server.SessionExpiredHandler#handleSessionExpired(com.vaadin
     * .server.VaadinRequest, com.vaadin.server.VaadinResponse)
     */
    @Override
    public boolean handleSessionExpired(VaadinRequest request,
            VaadinResponse response) throws IOException {
        if (!ServletPortletHelper.isHeartbeatRequest(request)) {
            return false;
        }

        response.sendError(HttpServletResponse.SC_GONE, "Session expired");
        return true;
    }
}
