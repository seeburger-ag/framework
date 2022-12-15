/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;

import com.vaadin.tests.util.MockDeploymentConfiguration;

/**
 *
 * @author Vaadin Ltd
 */
public class MockVaadinServletService extends VaadinServletService {

    public MockVaadinServletService() throws ServiceException {
        this(new MockDeploymentConfiguration());
    }

    public MockVaadinServletService(
            DeploymentConfiguration deploymentConfiguration) throws ServiceException {
        this(new VaadinServlet(), deploymentConfiguration);
    }

    public MockVaadinServletService(VaadinServlet servlet,
            DeploymentConfiguration deploymentConfiguration) throws ServiceException {
        super(servlet, deploymentConfiguration);

        try {
            servlet.init(new MockServletConfig());
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected List<RequestHandler> createRequestHandlers()
            throws ServiceException {
        return Collections.emptyList();
    }

    @Override
    public void init() {
        try {
            super.init();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

}
