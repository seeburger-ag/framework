/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server.gwtrpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.vaadin.tests.widgetset.client.gwtrpc.GwtRpcServiceTest;

/**
 * Test GWT RPC in Vaadin DevMode.
 *
 * @author Vaadin Ltd
 */
@SuppressWarnings("serial")
public class GwtRpcServletTest extends RemoteServiceServlet
        implements GwtRpcServiceTest {

    @Override
    public String giveMeThat(String that, String haveThis) {
        return "Take " + that + " for " + haveThis;
    }

}
