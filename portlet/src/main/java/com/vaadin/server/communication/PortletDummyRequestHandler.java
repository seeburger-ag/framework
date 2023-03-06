/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.vaadin.server.RequestHandler;
import com.vaadin.server.VaadinPortletResponse;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinSession;

/**
 * Request handler which provides a dummy HTML response to any resource request
 * with the resource id DUMMY.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public class PortletDummyRequestHandler implements RequestHandler {

    @Override
    public boolean handleRequest(VaadinSession session, VaadinRequest request,
            VaadinResponse response) throws IOException {
        if (!isDummyRequest(request)) {
            return false;
        }

        /*
         * This dummy page is used by action responses to redirect to, in order
         * to prevent the boot strap code from being rendered into strange
         * places such as iframes.
         */
        PortletResponse portletResponse = ((VaadinPortletResponse) response)
                .getPortletResponse();
        if (portletResponse instanceof ResourceResponse) {
            ((ResourceResponse) portletResponse).setContentType("text/html");
        }

        final OutputStream out = ((ResourceResponse) response)
                .getPortletOutputStream();
        final PrintWriter outWriter = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(out, "UTF-8")));
        outWriter.print("<html><body>dummy page</body></html>");
        outWriter.close();

        return true;
    }

    public static boolean isDummyRequest(VaadinRequest request) {
        ResourceRequest resourceRequest = PortletUIInitHandler
                .getResourceRequest(request);
        if (resourceRequest == null) {
            return false;
        }

        return resourceRequest.getResourceID() != null
                && resourceRequest.getResourceID().equals("DUMMY");
    }

}
