/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.gwtrpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Test GWT RPC in Vaadin DevMode.
 *
 * @author Vaadin Ltd
 */
public interface GwtRpcServiceTestAsync {

    /*
     * Dummy async method to verify if RPC works.
     */
    void giveMeThat(String that, String haveThis,
            AsyncCallback<String> callback);

}
