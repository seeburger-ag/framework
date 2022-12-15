/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import com.vaadin.server.VaadinPortletRequest;
import com.vaadin.server.VaadinRequest;

public class PortletUIInitHandler extends UIInitHandler {

    @Override
    protected boolean isInitRequest(VaadinRequest request) {
        return isUIInitRequest(request);
    }

    public static boolean isUIInitRequest(VaadinRequest request) {
        ResourceRequest resourceRequest = getResourceRequest(request);
        if (resourceRequest == null) {
            return false;
        }

        return UIInitHandler.BROWSER_DETAILS_PARAMETER
                .equals(resourceRequest.getResourceID());
    }

    /**
     * Returns the {@link ResourceRequest} for the given request or null if none
     * could be found.
     *
     * @param request
     *            The original request, must be a {@link VaadinPortletRequest}
     * @return The resource request from the request parameter or null
     */
    static ResourceRequest getResourceRequest(VaadinRequest request) {
        if (!(request instanceof VaadinPortletRequest)) {
            throw new IllegalArgumentException(
                    "Request must a VaadinPortletRequest");
        }
        PortletRequest portletRequest = ((VaadinPortletRequest) request)
                .getPortletRequest();
        if (!(portletRequest instanceof ResourceRequest)) {
            return null;
        }

        return (ResourceRequest) portletRequest;

    }
}
