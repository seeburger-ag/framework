/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import com.vaadin.server.VaadinRequest;

public class ServletUIInitHandler extends UIInitHandler {

    @Override
    protected boolean isInitRequest(VaadinRequest request) {
        return isUIInitRequest(request);
    }

    public static boolean isUIInitRequest(VaadinRequest request) {
        return "POST".equals(request.getMethod()) && request
                .getParameter(UIInitHandler.BROWSER_DETAILS_PARAMETER) != null;
    }

}
