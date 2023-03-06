/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class LegacyVaadinServlet extends VaadinServlet {

    private static final UIProvider provider = new LegacyApplicationUIProvider() {
        @Override
        protected LegacyApplication createApplication() {

            VaadinServlet servlet = VaadinServlet.getCurrent();
            if (servlet instanceof LegacyVaadinServlet) {
                LegacyVaadinServlet legacyServlet = (LegacyVaadinServlet) servlet;
                HttpServletRequest request = VaadinServletService
                        .getCurrentServletRequest();
                try {
                    if (legacyServlet.shouldCreateApplication(request)) {
                        return legacyServlet.getNewApplication(request);
                    }
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
            }
            return null;
        }
    };

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        getService().addSessionInitListener(new SessionInitListener() {
            @Override
            public void sessionInit(SessionInitEvent event)
                    throws ServiceException {
                try {
                    onVaadinSessionStarted(event.getRequest(),
                            event.getSession());
                } catch (ServletException e) {
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

    protected LegacyApplication getNewApplication(HttpServletRequest request)
            throws ServletException {
        try {
            Class<? extends LegacyApplication> applicationClass = getApplicationClass();
            return applicationClass.newInstance();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected boolean shouldCreateApplication(HttpServletRequest request)
            throws ServletException {
        return true;
    }

    private void onVaadinSessionStarted(VaadinRequest request,
            VaadinSession session) throws ServletException {
        session.addUIProvider(provider);
    }

}
