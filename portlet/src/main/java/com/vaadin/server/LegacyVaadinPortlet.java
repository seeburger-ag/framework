/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

public class LegacyVaadinPortlet extends VaadinPortlet {

    private static final LegacyApplicationUIProvider provider = new LegacyApplicationUIProvider() {
        @Override
        protected LegacyApplication createApplication() {
            VaadinPortlet portlet = VaadinPortlet.getCurrent();
            if (portlet instanceof LegacyVaadinPortlet) {
                LegacyVaadinPortlet legacyPortlet = (LegacyVaadinPortlet) portlet;
                PortletRequest request = VaadinPortletService
                        .getCurrentPortletRequest();
                if (legacyPortlet.shouldCreateApplication(request)) {
                    try {
                        return legacyPortlet.getNewApplication(request);
                    } catch (PortletException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return null;
        }
    };

    @Override
    public void init(PortletConfig portletConfig) throws PortletException {
        super.init(portletConfig);

        getService().addSessionInitListener(new SessionInitListener() {
            @Override
            public void sessionInit(SessionInitEvent event)
                    throws ServiceException {
                try {
                    onVaadinSessionStarted(
                            (VaadinPortletRequest) event.getRequest(),
                            (VaadinPortletSession) event.getSession());
                } catch (PortletException e) {
                    throw new ServiceException(e);
                }
            }
        });
    }

    protected Class<? extends LegacyApplication> getApplicationClass()
            throws ClassNotFoundException {
        try {
            return ServletPortletHelper.getLegacyApplicationClass(getService());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    protected LegacyApplication getNewApplication(PortletRequest request)
            throws PortletException {
        try {
            Class<? extends LegacyApplication> applicationClass = getApplicationClass();
            return applicationClass.newInstance();
        } catch (Exception e) {
            throw new PortletException(e);
        }
    }

    private void onVaadinSessionStarted(VaadinPortletRequest request,
            VaadinPortletSession session) throws PortletException {
        session.addUIProvider(provider);
    }

    protected boolean shouldCreateApplication(PortletRequest request) {
        return true;
    }
}
